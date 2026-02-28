class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int rem = (int)(prefix[n] % p);
        if (rem == 0) return 0;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int minLen = n;
        for (int i = 0; i <= n; i++) {
            int cur = (int)(prefix[i] % p);
            int target = (cur - rem + p) % p;
            if (lastSeen.containsKey(target)) {
                minLen = Math.min(minLen, i - lastSeen.get(target));
            }
            lastSeen.put(cur, i);
        }
        return minLen == n ? -1 : minLen;
    }
}