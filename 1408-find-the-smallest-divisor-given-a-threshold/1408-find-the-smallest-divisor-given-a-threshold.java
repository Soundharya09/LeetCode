class Solution {
    public boolean isLess(int mid, int[] nums, int t) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % mid == 0) sum += nums[i] / mid;
            else sum += nums[i] / mid + 1;
        }
        if(sum <= t) return true;
        return false;
    }
    public int smallestDivisor(int[] nums, int t) {
        int n = nums.length;
        int mx = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
        }
        int d = 1;
        int low = 1, high = mx;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isLess(mid, nums, t)) {
                d = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return d;
    }
}