class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n]; // dp[i][j] initialized to 0

        // process by increasing subarray length so dp[i][k] and dp[k+1][j] 
        // (both shorter than [i,j]) are already computed
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int total = prefix[j + 1] - prefix[i];
                int best = 0;
                for (int k = i; k < j; k++) {
                    int left = prefix[k + 1] - prefix[i];
                    int right = total - left;
                    if (left < right) {
                        best = Math.max(best, left + dp[i][k]);
                    } else if (left > right) {
                        best = Math.max(best, right + dp[k + 1][j]);
                    } else {
                        best = Math.max(best, left + Math.max(dp[i][k], dp[k + 1][j]));
                    }
                }
                dp[i][j] = best;
            }
        }

        return dp[0][n - 1];
    }
}