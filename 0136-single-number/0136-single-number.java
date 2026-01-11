class Solution {
    public int singleNumber(int[] nums) {
        // Approach - 1 -> Brute-Force Approach
        // Arrays.sort(nums);
        // int n = nums.length;
        // for(int i = 0; i < n-1; i += 2) {
        //     if(nums[i] != nums[i+1]) return nums[i];
        // }
        // return nums[n - 1];

        // Approach - 2 -> XOR Approach
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }
}