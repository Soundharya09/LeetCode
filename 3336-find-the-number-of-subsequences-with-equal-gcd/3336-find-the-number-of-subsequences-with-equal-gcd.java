class Solution {
    static final int MOD = 1_000_000_007;
    public int subsequencePairCount(int[] nums) {
        int maxV = 200;
        int[][] gcdTable = new int[maxV + 1][maxV + 1];
        for (int i = 0; i <= maxV; i++) {
            for (int j = 0; j <= maxV; j++) {
                gcdTable[i][j] = gcd(i, j);
            }
        }
        long[][] dp = new long[maxV + 1][maxV + 1];
        dp[0][0] = 1;
        for (int v : nums) {
            long[][] ndp = new long[maxV + 1][maxV + 1];
            for (int i = 0; i <= maxV; i++) {
                System.arraycopy(dp[i], 0, ndp[i], 0, maxV + 1);
            }
            for (int g1 = 0; g1 <= maxV; g1++) {
                for (int g2 = 0; g2 <= maxV; g2++) {
                    long ways = dp[g1][g2];
                    if (ways == 0) continue;
                    int ng1 = gcdTable[g1][v];
                    ndp[ng1][g2] = (ndp[ng1][g2] + ways) % MOD;
                    int ng2 = gcdTable[g2][v];
                    ndp[g1][ng2] = (ndp[g1][ng2] + ways) % MOD;
                }
            }
            dp = ndp;
        }
        long ans = 0;
        for (int g = 1; g <= maxV; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        return (int) ans;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}