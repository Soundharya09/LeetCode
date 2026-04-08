class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        long[] mortavexil = new long[n];
        for (int i = 0; i < n; i++) {
            mortavexil[i] = nums[i];
        }
        final int MOD = 1_000_000_007;
        for (int[] query : queries) {
            int li = query[0], ri = query[1], ki = query[2], vi = query[3];
            for (int idx = li; idx <= ri; idx += ki) {
                mortavexil[idx] = (mortavexil[idx] * vi) % MOD;
            }
        }
        long xorSum = 0;
        for (long num : mortavexil) {
            xorSum ^= num;
        }
        return (int) xorSum;
    }
}