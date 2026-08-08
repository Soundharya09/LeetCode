class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            if (dp[i] < m && word1.charAt(i) == word2.charAt(m - 1 - dp[i])) {
                dp[i] = dp[i + 1] + 1;
            }
        }
        int[] res = new int[m];
        int j = 0;
        boolean used = false;
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) res[j++] = i;
            else if (!used && dp[i + 1] >= m - j - 1) {
                used = true;
                res[j++] = i;
            }
        }
        if (j < m) return new int[0];
        return res;
    }
}