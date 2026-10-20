class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            if (isSortable(nums, n, k)) ans += k;
        }
        return ans;
    }
    private boolean isSortable(int[] nums, int n, int k) {
        int prevMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int end = start + k;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int descents = 0;

            for (int i = start; i < end; i++) {
                int cur = nums[i];
                int next = (i + 1 < end) ? nums[i + 1] : nums[start]; 
                if (cur > next) descents++;
                if (cur < min) min = cur;
                if (cur > max) max = cur;
            }
            if (descents > 1) return false;
            if (prevMax > min) return false;
            prevMax = max;
        }
        return true;
    }
}