class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int prev2 = 0, prev1 = 0;
        for(int num : nums) {
            int curr = Math.max(prev2 + num, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}