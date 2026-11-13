class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nums[n - 1 - i];

        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + a[i];

        int[] dq = new int[n];
        int head = 0, tail = 0;      
        long[] cnt = new long[n];    
        long sumMax = 0;
        long ans = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            long c = 1;
            while (head < tail && a[dq[tail - 1]] <= a[r]) {
                int b = dq[--tail];
                sumMax -= a[b] * cnt[b];
                c += cnt[b];
            }
            dq[tail++] = r;
            cnt[r] = c;
            sumMax += a[r] * c;

            while (sumMax - (pre[r + 1] - pre[l]) > k) {
                int f = dq[head];
                sumMax -= a[f];
                cnt[f]--;
                if (cnt[f] == 0) head++;
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}