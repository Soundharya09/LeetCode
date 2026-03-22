class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int r = 0; r < 4; r++) {
            boolean match = true;
            for(int i = 0; i < mat.length && match; i++) {
                for(int j = 0; j < mat.length && match; j++) {
                    if(mat[i][j] != target[i][j]) match = false;
                }
            }
            if(match) return true;
            mat = rotate90(mat);
        }
        return false;
    }
    public int[][] rotate90(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = mat[i][j];
            }
        }      
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = res[i][left];
                res[i][left] = res[i][right];
                res[i][right] = temp;
                left++; right--;
            }
        }
        return res;
    }
}