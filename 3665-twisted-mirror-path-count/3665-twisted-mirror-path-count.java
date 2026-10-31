class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;

        int[][][] f = new int[m + 1][n + 1][2];
        for (int[][] row : f) {
            for (int[] cell : row) {
                cell[0] = cell[1] = -1;
            }
        }
        for (int x = m - 1; x >= 0; x--) {
            for (int y = n - 1; y >= 0; y--) {
                if (grid[x][y] == 0) f[x][y][0] = f[x][y][1] = x * n + y;
                else {
                    f[x][y][0] = f[x + 1][y][1]; 
                    f[x][y][1] = f[x][y + 1][0]; 
                }
            }
        }
        int[] dp = new int[m * n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                int cur = dp[i * n + j];
                if (cur == 0) continue;
                if (j + 1 < n) {
                    int t = f[i][j + 1][0];
                    if (t != -1) dp[t] = (dp[t] + cur) % MOD;
                }
                if (i + 1 < m) {
                    int t = f[i + 1][j][1];
                    if (t != -1) dp[t] = (dp[t] + cur) % MOD;
                }
            }
        }
        return dp[m * n - 1];
    }
}