class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int MOD = 12345;
        int[][] p = new int[n][m];
        int[][] prefix = new int[n][m];
        int[][] suffix = new int[n][m];
        
        prefix[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                if (j == 0) {
                    prefix[i][j] = (int)((1L * prefix[i-1][m-1] * grid[i-1][m-1]) % MOD);
                } 
                else {
                    prefix[i][j] = (int)((1L * prefix[i][j-1] * grid[i][j-1]) % MOD);
                }
            }
        }
        suffix[n - 1][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;
                if (j == m - 1) {
                    suffix[i][j] = (int)((1L * suffix[i+1][0] * grid[i+1][0]) % MOD);
                } 
                else {
                    suffix[i][j] = (int)((1L * suffix[i][j+1] * grid[i][j+1]) % MOD);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int)((1L * prefix[i][j] * suffix[i][j]) % MOD);
            }
        }
        return p;
    }
}