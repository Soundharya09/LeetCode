class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] cnt = new int[31];
        for (int x : nums) {
            for (int b = 0; b < 31; b++) {
                if (((x >> b) & 1) == 1) cnt[b]++;
            }
        }
        long mod = 1_000_000_007L;
        long ans = 0;
        for (int i = 0; i < k; i++) {
            long cur = 0;
            for (int b = 0; b < 31; b++) {
                if (cnt[b] > 0) {
                    cur |= (1L << b);
                    cnt[b]--;
                }
            }
            cur %= mod;
            ans = (ans + cur * cur) % mod;
        }
        return (int) ans;
    }
}