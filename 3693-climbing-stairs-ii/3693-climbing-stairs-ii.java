class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int j = 1; j <= n; j++) {
            int best = Integer.MAX_VALUE;
            for(int d = 1; d <= 3; d++) {
                int i = j - d;
                if(i < 0) break;
                best = Math.min(best, dp[i] + costs[j - 1] + d * d);
            }
            dp[j] = best;
        }
        return dp[n];
    }
}