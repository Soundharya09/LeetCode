class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        //first position
        int fp = -1, low = 0, high = n-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid > 0 && nums[mid] == nums[mid-1]) high = mid - 1;
                else {
                    fp = mid; 
                    break;
                }
            }
            else if(nums[mid] < target) low = mid + 1;
            else if(nums[mid] > target) high = mid - 1;
        }
        //last position
        int lp = -1; low = 0; high = n-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid + 1 < n && nums[mid] == nums[mid+1]) low = mid + 1;
                else {
                    lp = mid;
                    break;
                }
            }
            else if(nums[mid] < target) low = mid + 1;
            else if(nums[mid] > target) high = mid - 1;
        }
        ans[0] = fp; ans[1] = lp;
        return ans;
    }
}