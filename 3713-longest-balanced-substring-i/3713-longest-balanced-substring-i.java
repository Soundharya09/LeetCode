class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int[] count = new int[26];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            Arrays.fill(count, 0);
            int mx = 0, v = 0;
            for(int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';
                if(++count[c] == 1) v++;
                mx = Math.max(mx, count[c]);
                if(mx * v == j - i + 1) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}