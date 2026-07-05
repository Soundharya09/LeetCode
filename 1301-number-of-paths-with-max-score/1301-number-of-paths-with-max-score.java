class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;
        long[][] dp = new long[n][n];
        long[][] cnt = new long[n][n];
        for (long[] row : dp) Arrays.fill(row, -1);
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = board.get(i).toCharArray();
        }
        dp[n-1][n-1] = 0;
        cnt[n-1][n-1] = 1;
        int[] di = {1, 0, 1};
        int[] dj = {0, 1, 1};
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n-1 && j == n-1) continue; 
                if (grid[i][j] == 'X') {
                    dp[i][j] = -1;
                    cnt[i][j] = 0;
                    continue;
                }
                long best = -1;
                long ways = 0;
                for (int k = 0; k < 3; k++) {
                    int ni = i + di[k];
                    int nj = j + dj[k];
                    if (ni < n && nj < n && dp[ni][nj] != -1) {
                        if (dp[ni][nj] > best) {
                            best = dp[ni][nj];
                            ways = cnt[ni][nj];
                        } 
                        else if (dp[ni][nj] == best) ways = (ways + cnt[ni][nj]) % MOD;
                    }
                }
                if (best == -1) {
                    dp[i][j] = -1;
                    cnt[i][j] = 0;
                } 
                else {
                    int val = (grid[i][j] == 'E' || grid[i][j] == 'S') ? 0 : (grid[i][j] - '0');
                    dp[i][j] = best + val;
                    cnt[i][j] = ways;
                }
            }
        }
        if (dp[0][0] == -1) return new int[]{0, 0};
        return new int[]{(int) dp[0][0], (int) cnt[0][0]};
    }
}