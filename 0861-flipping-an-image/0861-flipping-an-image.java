class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        int dim = arr.length;
        for(int i=0; i<dim; i++){
            int start = 0;
            int end = dim - 1;

            while(start <= end){
                int temp = arr[i][start] ^ 1;
                arr[i][start] = arr[i][end] ^ 1;
                arr[i][end] = temp;
                start++;
                end--;
            }
        }
        return arr;
    }
}