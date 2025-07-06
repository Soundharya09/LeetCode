class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++) {
            int j = 0;
            int[] ans = new int[Math.min(n-j, m-i)];
            int x = i;
            while(x < m && j < n) {
                ans[x-i] = mat[x++][j++];
            }
            x = i; j = 0;
            Arrays.sort(ans);
            while(x < m && j < n) {
                mat[x][j++] = ans[x-i];
                x++;
            }
        }
        for(int j = 0; j < n; j++) {
            int i = 0;
            int[] ans = new int[Math.min(n-j, m-i)];
            int x = j;
            while(x < n && i < m) {
                ans[i] = mat[i++][x++];
            }
            x = j; i = 0;
            Arrays.sort(ans);
            while(x < n && i < m) {
                mat[i][x++] = ans[i++];
            }
        }
        return mat;
    }
}