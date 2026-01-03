class Solution {
    public int singleNumber(int[] nums) {
        // Approach - 1 -> Brute-Force
        // for(int i = 0; i < nums.length; i++) {
        //     int count = 0;
        //     for(int j = 0; j < nums.length; j++) {
        //         if(nums[i] == nums[j]) count++;
        //     }
        //     if(count == 1) return nums[i];
        // }
        // return -1;

        // Approach - 2 -> Bit Manipulation
        int ones = 0, twos = 0;
        for(int x : nums) {
            ones = (ones ^ x) & ~twos;
            twos = (twos ^ x) & ~ones;
        }
        return ones;
    }
}