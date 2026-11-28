class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] cnt = new int[n + 1];
        for (int[] it : items) cnt[it[0]]++;

        int[] multSum = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            int s = 0;
            for (int k = f; k <= n; k += f) s += cnt[k];
            multSum[f] = s;
        }

        long m = Long.MAX_VALUE;
        for (int[] it : items) m = Math.min(m, it[1]);

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Integer.compare(items[a][1], items[b][1]));

        long rem = budget;
        long total = 0;
        for (int id : idx) {
            long p = items[id][1];
            if (p >= 2 * m) break;
            long gain = multSum[items[id][0]] - 1;
            if (gain <= 0) continue;
            long t = Math.min(gain, rem / p);
            if (t <= 0) continue;
            rem -= t * p;
            total += 2 * t;
        }
        total += rem / m;
        return (int) total;
    }
}