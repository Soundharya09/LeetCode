class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int m = arr.length, n = arr[0].length;
        int i = 0, j = n-1;
        boolean flag = false; //target not found

        while(i < m && j >= 0){
            if(arr[i][j] == target){
                flag = true; //target found
                break;
            }
            else if(arr[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        if(flag == true) return true;
        else return false;
    }
}