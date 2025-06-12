class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int ans = Math.abs(nums[0] - nums[n-1]);
        for(int i = 1; i < n; i++) {
            int diff = Math.abs(nums[i] - nums[i-1]);
            ans = Math.max(ans, diff);
        }
        return ans;
    }
}