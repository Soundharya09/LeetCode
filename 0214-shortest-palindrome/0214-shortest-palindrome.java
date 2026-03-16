class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return s;
        long mod = 1_000_000_007L;
        long base = 31L, forwardHash = 0, reverseHash = 0, power = 1L;
        int bestLen = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a' + 1;
            // Forward hash
            forwardHash = (forwardHash * base + c) % mod;
            // Reverse hash
            reverseHash = (reverseHash + c * power) % mod;
            power = power * base % mod;
            if (forwardHash == reverseHash) bestLen = i + 1;
        }
        String suffix = s.substring(bestLen);
        String reversedSuffix = new StringBuilder(suffix).reverse().toString();
        return reversedSuffix + s;
    }
}