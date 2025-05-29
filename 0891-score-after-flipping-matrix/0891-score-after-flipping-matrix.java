class Solution {
    public int matrixScore(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        for(int i=0; i<m; i++){
            if(arr[i][0] == 0){ // flipping row
                for(int j=0; j<n; j++){ // converting 0 to 1 and vice-versa
                    if(arr[i][j] == 0) arr[i][j] = 1;
                    else arr[i][j] = 0;
                }
            }
        }
        for(int j=1; j<n; j++){ //flip columns where 0s > 1s
            int noOfZeros = 0, noOfOnes = 0;
            for(int i=0; i<m; i++){
                if(arr[i][j] == 0) noOfZeros++;
                else noOfOnes++;
            }
            if(noOfZeros > noOfOnes){
                for(int i=0; i<m; i++){ //converting 0 to 1 and vice-versa
                    if(arr[i][j] == 0) arr[i][j] = 1;
                    else arr[i][j] = 0;
                }
            }
        }
        int score = 0;
        int x = 1;
        for(int j=n-1; j>=0; j--){
            for(int i=0; i<m; i++){ //converting binary row to decimal
                score += (arr[i][j] * x);
            }
            x *= 2;
        }
        return score;
    }
}