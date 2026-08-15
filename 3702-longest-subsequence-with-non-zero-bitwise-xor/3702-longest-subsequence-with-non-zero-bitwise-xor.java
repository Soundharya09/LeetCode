class Solution {
    public int longestSubsequence(int[] nums) {
        int xorAll = 0;
        boolean hasNonZero = false;
        for (int x : nums) {
            xorAll ^= x;
            if (x != 0) hasNonZero = true;
        }
        int n = nums.length;
        if (xorAll != 0) return n;
        else return hasNonZero ? n - 1 : 0;
    }
}