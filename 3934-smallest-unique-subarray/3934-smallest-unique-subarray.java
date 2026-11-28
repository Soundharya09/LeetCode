class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int low = 1, high = n;
        while(low < high) {
            int mid = (low + high) / 2;
            if(hasUnique(nums, mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
    public boolean hasUnique(int[] nums, int len) {
        Map<Long, Integer> count = new HashMap<>();
        long MOD = 1_000_000_007L;
        long base = 100001L;
        long hash = 0, power = 1;
        for(int i = 0; i < len; i++) {
            hash = (hash * base + nums[i]) % MOD;
            if(i > 0) power = (power * base) % MOD;
        }
        count.merge(hash, 1, Integer::sum);
        for(int i = len; i < nums.length; i++) {
            hash = (hash - nums[i - len] * power % MOD + MOD) % MOD;
            hash = (hash * base + nums[i]) % MOD;
            count.merge(hash, 1, Integer::sum);
        }
        return count.containsValue(1);
    }
}