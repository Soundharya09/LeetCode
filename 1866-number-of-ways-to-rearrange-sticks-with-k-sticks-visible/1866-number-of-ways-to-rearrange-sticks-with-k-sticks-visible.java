class Solution {
    private static final int MOD = 1_000_000_007;
    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= Math.min(i, k); j++) {
                long t1 = dp[i - 1][j - 1];
                long t2 = dp[i - 1][j] * (i - 1) % MOD;
                dp[i][j] = (t1 + t2) % MOD;
            }
        }
        return (int) dp[n][k];
    }
}