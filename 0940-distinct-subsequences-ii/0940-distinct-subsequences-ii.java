class Solution {
    public int distinctSubseqII(String s) {
        long[] dp = new long[26];
        long mod = 1000000007;
        long totalSum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            long old = dp[c];
            long newVal = (totalSum + 1) % mod;
            dp[c] = newVal;
            totalSum = (totalSum - old + newVal + mod) % mod;
        }
        return (int) totalSum;
    }
}