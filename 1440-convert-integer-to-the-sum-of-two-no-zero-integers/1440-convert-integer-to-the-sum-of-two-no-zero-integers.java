class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int a = 1; a < n; a++){
            int b = n - a;
            if (isNoZero(a) && isNoZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{0, 0}; 
    }
    
    private boolean isNoZero(int num) {
        String str = String.valueOf(num);
        return !str.contains("0");
    }
}