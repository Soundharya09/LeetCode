class Solution {
    public int maxProduct(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int product = (nums[i] - 1) * (nums[j] - 1);
                ans = Math.max(ans, product);
            }
        }
        return ans;
    }
}