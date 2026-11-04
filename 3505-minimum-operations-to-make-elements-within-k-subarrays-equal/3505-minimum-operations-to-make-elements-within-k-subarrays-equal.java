class Solution {
    int m;
    long[] cnt, sum;

    void update(int i, long c, long v) {
        for (; i <= m; i += i & -i) {
            cnt[i] += c;
            sum[i] += v;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int[] sorted = Arrays.stream(nums).distinct().sorted().toArray();
        m = sorted.length;
        cnt = new long[m + 1];
        sum = new long[m + 1];
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = Arrays.binarySearch(sorted, nums[i]) + 1;
        }
        int LOG = Integer.highestOneBit(m);
        int numWindows = n - x + 1;
        long[] cost = new long[numWindows];
        long total = 0;

        for (int i = 0; i < n; i++) {
            update(idx[i], 1, nums[i]);
            total += nums[i];
            if (i >= x) {
                update(idx[i - x], -1, -nums[i - x]);
                total -= nums[i - x];
            }
            if (i >= x - 1) {
                long rem = (x + 1) / 2;
                int pos = 0;
                for (int pw = LOG; pw > 0; pw >>= 1) {
                    if (pos + pw <= m && cnt[pos + pw] < rem) {
                        pos += pw;
                        rem -= cnt[pos];
                    }
                }
                long med = sorted[pos];
                long cLE = 0, sLE = 0;
                for (int p = pos + 1; p > 0; p -= p & -p) {
                    cLE += cnt[p];
                    sLE += sum[p];
                }
                cost[i - x + 1] = med * cLE - sLE + (total - sLE) - med * (x - cLE);
            }
        }
        final long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        for (int j = 1; j <= k; j++) {
            long[] cur = new long[n + 1];
            Arrays.fill(cur, INF);
            for (int i = x; i <= n; i++) {
                cur[i] = cur[i - 1];
                if (prev[i - x] < INF) {
                    cur[i] = Math.min(cur[i], prev[i - x] + cost[i - x]);
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}