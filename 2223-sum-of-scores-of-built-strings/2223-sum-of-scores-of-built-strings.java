class Solution {
    public long sumScores(String s) {
        int n = s.length();
        long BASE1 = 31, MOD1 = 1_000_000_007L;
        long BASE2 = 37, MOD2 = 1_000_000_009L;
        long[] h1 = new long[n + 1], h2 = new long[n + 1];
        long[] p1 = new long[n + 1], p2 = new long[n + 1];
        p1[0] = p2[0] = 1;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a' + 1;
            h1[i + 1] = (h1[i] * BASE1 + c) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + c) % MOD2;
            p1[i + 1] = p1[i] * BASE1 % MOD1;
            p2[i + 1] = p2[i] * BASE2 % MOD2;
        }
        long sum = n;
        for (int i = 1; i < n; i++) {
            int lo = 0, hi = n - i;
            while (lo < hi) {
                int mid = (lo + hi + 1) >>> 1;
                if (hashEq(h1, p1, MOD1, h2, p2, MOD2, 0, i, mid)) lo = mid;
                else hi = mid - 1;
            }
            sum += lo;
        }
        return sum;
    }
    public boolean hashEq(
        long[] h1, long[] p1, long MOD1,
        long[] h2, long[] p2, long MOD2,
        int a, int b, int len
    ) {
        long ha1 = (h1[a + len] - h1[a] * p1[len] % MOD1 + MOD1 * 2) % MOD1;
        long hb1 = (h1[b + len] - h1[b] * p1[len] % MOD1 + MOD1 * 2) % MOD1;
        long ha2 = (h2[a + len] - h2[a] * p2[len] % MOD2 + MOD2 * 2) % MOD2;
        long hb2 = (h2[b + len] - h2[b] * p2[len] % MOD2 + MOD2 * 2) % MOD2;
        return ha1 == hb1 && ha2 == hb2;
    }
}