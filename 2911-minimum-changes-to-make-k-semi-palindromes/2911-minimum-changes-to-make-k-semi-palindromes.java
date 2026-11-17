class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        final int INF = 1_000_000;
        char[] c = s.toCharArray();

        List<List<Integer>> divs = new ArrayList<>();
        for (int len = 0; len <= n; len++) divs.add(new ArrayList<>());
        for (int len = 2; len <= n; len++) {
            for (int d = 1; d < len; d++) {
                if (len % d == 0) divs.get(len).add(d);
            }
        }
        int[][] cost = new int[n][n];
        for (int[] row : cost) Arrays.fill(row, INF);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                int best = INF;
                for (int d : divs.get(len)) {
                    int changes = 0;
                    int m = len / d; 
                    for (int r = 0; r < d; r++) {
                        int lo = 0, hi = m - 1;
                        while (lo < hi) {
                            if (c[i + r + lo * d] != c[i + r + hi * d]) changes++;
                            lo++;
                            hi--;
                        }
                    }
                    best = Math.min(best, changes);
                }
                cost[i][j] = best;
            }
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;
        for (int j = 1; j <= k; j++) {
            for (int p = 2 * j; p <= n; p++) {
                for (int x = 2 * (j - 1); x <= p - 2; x++) {
                    if (dp[x][j - 1] >= INF || cost[x][p - 1] >= INF) continue;
                    dp[p][j] = Math.min(dp[p][j], dp[x][j - 1] + cost[x][p - 1]);
                }
            }
        }
        return dp[n][k];
    }
}