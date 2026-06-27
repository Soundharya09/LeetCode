class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> count = new HashMap<>();
        for (int num : nums) {
            long n = (long) num;
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        int c1 = count.getOrDefault(1L, 0);
        int ans = (c1 % 2 == 0 && c1 > 0) ? c1 - 1 : c1;
        if (ans == 0) ans = 1;
        for (long x : count.keySet()) {
            if (x == 1L) continue;
            int length = 0;
            long cur = x;
            while (count.getOrDefault(cur, 0) > 1) {
                cur = cur * cur;
                length += 2;
                if (cur > 2_000_000_000L) break;
            }
            length += count.getOrDefault(cur, 0) >= 1 ? 1 : -1;
            ans = Math.max(ans, length);
        }
        return ans;
    }
}