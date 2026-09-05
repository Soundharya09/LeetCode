class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                if (nums[j] > maxVal) maxVal = nums[j];
            }
            int minVal = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (nums[j] < minVal) minVal = nums[j];
            }
            if (maxVal - minVal <= k) return i;
        }
        return -1;
    }
}