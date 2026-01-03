class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        long abc = 6;
        long aba = 6;

        for(int i = 2; i <= n; i++) {
            long newABC = (abc * 2 + aba * 2) % MOD;
            long newABA = (abc * 2 + aba * 3) % MOD;

            abc = newABC;
            aba = newABA;
        }
        return (int)((abc + aba) % MOD);
    }
}