class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int major_ele = nums[0];
        int count = 1;
        for(int i = 1; i < n; i++) {
            if(count == 0) {
                major_ele = nums[i];
                count = 1;
            }
            else if(nums[i] == major_ele) count++;
            else count--;
        }
        return major_ele;
    }
}