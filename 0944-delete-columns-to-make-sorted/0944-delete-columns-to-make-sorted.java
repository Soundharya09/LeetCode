class Solution {
    public int minDeletionSize(String[] strs) {
       if(strs == null || strs.length == 0) return 0;
       int rows = strs.length;
       int cols = strs[0].length();
       int deleteCols = 0;

       for(int col = 0; col < cols; col++) {
            for (int row = 1; row < rows; row++) {
                if(strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    deleteCols++;
                    break;
                }
            }
        }
        return deleteCols;
    }
}