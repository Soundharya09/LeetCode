class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length, ans = -1;
        boolean[] seen = new boolean[51]; 
        for (int v : nums) {
            seen[v] = true;
        }
        for (int x = 50; x >= 0; x--) {
            if (!seen[x]) continue;
            int count = 0;
            for (int start = 0; start + k <= n; start++) {
                boolean contains = false;
                for (int i = start; i < start + k; i++) {
                    if (nums[i] == x) {
                        contains = true;
                        break;
                    }
                }
                if (contains) count++;
            }
            if (count == 1) {
                ans = x; 
                break;
            }
        }
        return ans;
    }
}