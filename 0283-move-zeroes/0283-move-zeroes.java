class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int noz = 0;
        for(int ele : nums) {
            if(ele == 0) noz++;
        }
        for(int x = 0; x < noz; x++) {
            for(int i = 0; i < n-1-x; i++) {
                if(nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }
    }
}