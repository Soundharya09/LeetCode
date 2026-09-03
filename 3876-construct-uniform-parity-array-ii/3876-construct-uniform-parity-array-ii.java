class Solution {
    public boolean uniformArray(int[] nums1) {
        return canMake(nums1, true) || canMake(nums1, false);
    }

    private boolean canMake(int[] nums1, boolean targetOdd) {
        int minOdd = Integer.MAX_VALUE;
        boolean hasOdd = false;
        
        for (int num : nums1) {
            if (num % 2 != 0) {
                hasOdd = true;
                minOdd = Math.min(minOdd, num);
            }
        }
        
        for (int num : nums1) {
            boolean isOdd = (num % 2 != 0);
            boolean matchesTarget = (isOdd == targetOdd);
            
            if (!matchesTarget) {
                if (!hasOdd || minOdd >= num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}