class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(t.length() < s.length()) return false;

        int tIdx = 0;
        int sIdx = 0;

        while(tIdx < t.length() && sIdx < s.length()) {
            if(t.charAt(tIdx) == s.charAt(sIdx)) sIdx++;
            tIdx++;
        }
        return sIdx == s.length();
    }
}