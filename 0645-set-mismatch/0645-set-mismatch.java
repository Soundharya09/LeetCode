class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        for(int n : nums) {
            int idx = Math.abs(n) - 1;
            if(nums[idx] < 0) duplicate = Math.abs(n);
            else nums[idx] = -nums[idx];
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) return new int[]{duplicate, i+1}; 
        }
        return new int[]{};
    }
}