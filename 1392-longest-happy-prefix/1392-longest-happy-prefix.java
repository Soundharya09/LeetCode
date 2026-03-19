class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        long BASE = 31, MOD = 1_000_000_007L;
        long prefixHash = 0, suffixHash = 0, power = 1; 
        String res = "";
        for (int i = 0; i < n - 1; i++) {
            int prefixChar = s.charAt(i)     - 'a' + 1;
            int suffixChar = s.charAt(n-1-i) - 'a' + 1;
            prefixHash = (prefixHash * BASE + prefixChar) % MOD;
            suffixHash = (suffixHash + suffixChar * power) % MOD;
            power = (power * BASE) % MOD;
            
            if (prefixHash == suffixHash) res = s.substring(0, i + 1); 
        }
        return res;
    }
}