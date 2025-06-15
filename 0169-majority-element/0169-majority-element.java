class Solution {
    public int majorityElement(int[] nums) {
        //Logic 1
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}