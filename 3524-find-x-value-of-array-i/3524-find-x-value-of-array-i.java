class Solution {
    public long[] resultArray(int[] nums, int k) {
          int n = nums.length;
        long[] result = new long[k];
        long[] dp = new long[k];
        
        for (int i = 0; i < n; i++) {
            long[] newDp = new long[k];
            int val = nums[i] % k;
            newDp[val]++;
            for (int r = 0; r < k; r++) {
                if (dp[r] == 0) continue;
                int newR = (int) ((r * (long) val) % k);
                newDp[newR] += dp[r];
            }
            dp = newDp;
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }
        return result;
    }
}