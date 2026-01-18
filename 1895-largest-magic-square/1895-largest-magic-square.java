class Solution {
    private boolean isMagicSquare(int[][] grid, int r, int c, int k) {
        if (k == 1) return true;
        // Magic constant = sum of first row
        int magic = 0;
        for (int j = 0; j < k; j++) {
            magic += grid[r][c + j];
        }
        // Check all other rows
        for (int i = 1; i < k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += grid[r + i][c + j];
            }
            if (sum != magic) return false;
        }
        // Check columns
        for (int j = 0; j < k; j++) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += grid[r + i][c + j];
            }
            if (sum != magic) return false;
        }
        // Main diagonal
        int d1 = 0;
        for (int i = 0; i < k; i++) {
            d1 += grid[r + i][c + i];
        }
        if (d1 != magic) return false;
        // Anti-diagonal
        int d2 = 0;
        for (int i = 0; i < k; i++) {
            d2 += grid[r + i][c + k - 1 - i];
        }
        if (d2 != magic) return false;
        return true;
    }
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int k = Math.min(m, n); k >= 1; k--) {
            for (int r = 0; r <= m - k; r++) {
                for (int c = 0; c <= n - k; c++) {
                    if (isMagicSquare(grid, r, c, k)) return k;
                }
            }
        }
        return 1;
    }
}