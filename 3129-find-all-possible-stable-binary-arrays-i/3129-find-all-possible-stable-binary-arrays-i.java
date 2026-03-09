class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        long[][][] dp = new long[zero + 1][one + 1][2];
        
        for (int i = 1; i <= Math.min(limit, zero); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(limit, one); j++) dp[0][j][1] = 1;
        
        for (int a = 0; a <= zero; a++) {
            for (int b = 0; b <= one; b++) {
                if (a == 0 && b == 0) continue;
                
                for (int c = 0; c <= 1; c++) {
                    if (a == 0 && c == 0) continue;
                    if (b == 0 && c == 1) continue;
            
                    if (b == 0 && c == 0) continue;
                    if (a == 0 && c == 1) continue;

                    long val = 0;
                    if (c == 0) {
                        val = (dp[a-1][b][0] + dp[a-1][b][1]) % MOD;
                        if (a > limit) {
                            val = (val - dp[a-limit-1][b][1] + MOD) % MOD;
                        }
                    } 
                    else {
                        val = (dp[a][b-1][0] + dp[a][b-1][1]) % MOD;
                        if (b > limit) {
                            val = (val - dp[a][b-limit-1][0] + MOD) % MOD;
                        }
                    }
                    dp[a][b][c] = val;
                }
            }
        }
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}