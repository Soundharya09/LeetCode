class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 1;
        int minCol = 0, maxCol = n-1;
        int minRow = 0, maxRow = n-1;

        while(count <= n*n){
            for(int i=minCol; i<=maxCol; i++){
                ans[minRow][i] = count;
                count++;
            }
            for(int j=minRow+1; j<=maxRow; j++){
                ans[j][maxCol] = count;
                count++;
            }
            for(int i=maxCol-1; i>=minCol; i--){
                ans[maxRow][i] = count;
                count++;
            }
            for(int j=maxRow-1; j>minRow; j--){
                ans[j][minCol] = count;
                count++;
            }
            minRow++;
            minCol++;
            maxRow--;
            maxCol--;
        }
        return ans;
    }
}