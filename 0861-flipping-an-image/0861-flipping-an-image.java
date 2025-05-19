class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < (n+1)/2; j++){
                int temp = arr[i][j];
                arr[i][j] = 1 - arr[i][n-1-j];
                arr[i][n-1-j] = 1 - temp;
            }
        }
        return arr;
    }
}