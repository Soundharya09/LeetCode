class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0, prev = 0, curr = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) curr++;
            else {
                prev = curr;
                curr = 1;
            }
            if(curr <= prev) res++;
        }
        return res;
    }
}