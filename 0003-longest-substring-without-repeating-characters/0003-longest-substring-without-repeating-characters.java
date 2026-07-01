class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIdx = new int[128];
        Arrays.fill(lastIdx, -1);
        int maxLen = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if(lastIdx[c] >= start) start = lastIdx[c] + 1;
            lastIdx[c] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}