class Solution {
    public int numWays(int steps, int arrLen) {
        int MOD = 1_000_000_007;
        int maxPos = Math.min(steps / 2 + 1, arrLen);
        int[] dp = new int[maxPos];
        dp[0] = 1;
        for (int s = 0; s < steps; s++) {
            int[] ndp = new int[maxPos];
            for (int i = 0; i < maxPos; i++) {
                if (dp[i] == 0) continue;
                ndp[i] = (int)((ndp[i] + (long)dp[i]) % MOD);
                if (i + 1 < maxPos) ndp[i+1] = (int)((ndp[i+1] + (long)dp[i]) % MOD);
                if (i - 1 >= 0) ndp[i-1] = (int)((ndp[i-1] + (long)dp[i]) % MOD);
            }
            dp = ndp;
        }
        return dp[0];
    }
}