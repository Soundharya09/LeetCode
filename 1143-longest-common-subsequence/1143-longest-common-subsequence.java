class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
         if (text2.length() > text1.length()) {
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
        }
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } 
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        return prev[n];
    }
}