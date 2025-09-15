class Solution {
    public boolean search(int[] nums, int target) {
        int n  = nums.length;
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) return true;
        }
        return false;
    }
}