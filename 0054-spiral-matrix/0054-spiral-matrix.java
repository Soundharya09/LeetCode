class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> ans = new ArrayList<>();
        int m = arr.length, n = arr[0].length;
        int min_r = 0, max_r = m-1;
        int min_c = 0, max_c = n-1;

        while(min_r <= max_r && min_c <= max_c){
            //left to right
            for(int j = min_c; j <= max_c; j++){
                ans.add(arr[min_r][j]);
            }  min_r++;
            //top to bottom
            if(min_r > max_r || min_c > max_c) break;
            for(int i = min_r; i <= max_r; i++){
                ans.add(arr[i][max_c]);
            }  max_c--;
            //right to left
            if(min_r > max_r || min_c > max_c) break;
            for(int j = max_c; j >= min_c; j--){
                ans.add(arr[max_r][j]);
            }  max_r--;
            //bottom to top
            if(min_r > max_r || min_c > max_c) break;
            for(int i = max_r; i >= min_r; i--){
                ans.add(arr[i][min_c]);
            }  min_c++;
        }
        return ans;
    }
}