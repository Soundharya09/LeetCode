class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalAbs = 0;
        int minAbs = Integer.MAX_VALUE, countNeg = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int val = matrix[i][j];
                int absVal = Math.abs(val);
                totalAbs += absVal;
                minAbs = Math.min(minAbs, absVal);
                if(val < 0) countNeg++;
            }
        }
        if(countNeg % 2 == 0) return totalAbs;
        else return totalAbs - 2L * minAbs; 
    }
}