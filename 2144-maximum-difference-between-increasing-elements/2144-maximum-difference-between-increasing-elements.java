class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int minEle = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(minEle < nums[i]) {
                maxDiff = Math.max(maxDiff, nums[i] - minEle);
            }
            else minEle = nums[i];
        }
        return maxDiff;
    }
}