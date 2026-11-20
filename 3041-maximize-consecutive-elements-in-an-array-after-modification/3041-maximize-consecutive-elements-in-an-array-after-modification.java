class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] dp = new int[max + 3];
        int ans = 1;

        for (int x : nums) {
            int raised = dp[x] + 1;
            int kept = dp[x - 1] + 1;
            dp[x + 1] = Math.max(dp[x + 1], raised);
            dp[x] = Math.max(dp[x], kept);
            ans = Math.max(ans, Math.max(dp[x], dp[x + 1]));
        }
        return ans;
    }
}