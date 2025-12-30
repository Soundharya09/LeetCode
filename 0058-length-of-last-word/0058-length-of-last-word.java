class Solution {
    public int lengthOfLastWord(String s) {
        // s = s.trim();
        // int lastIndex = s.lastIndexOf(' ');
        // return s.length() - lastIndex - 1;

        String[] ans = s.split("\\s+");
        return ans[ans.length - 1].length();
    }
}