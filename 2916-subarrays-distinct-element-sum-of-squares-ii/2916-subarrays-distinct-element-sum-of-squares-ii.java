class Solution {
    static final long MOD = 1_000_000_007L;
    long[] sum, sq, lazy;

    private void apply(int node, int len, long k) {
        sq[node] = (sq[node] + 2 * k % MOD * sum[node] % MOD + k * k % MOD * len % MOD) % MOD;
        sum[node] = (sum[node] + k * len) % MOD;
        lazy[node] = (lazy[node] + k) % MOD;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) >>> 1;
            apply(node * 2, mid - l + 1, lazy[node]);
            apply(node * 2 + 1, r - mid, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void update(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(node, r - l + 1, 1);
            return;
        }
        push(node, l, r);
        int mid = (l + r) >>> 1;
        if (ql <= mid) update(node * 2, l, mid, ql, qr);
        if (qr > mid) update(node * 2 + 1, mid + 1, r, ql, qr);
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100_001];
        Arrays.fill(last, -1);

        long ans = 0;
        for (int j = 0; j < n; j++) {
            int v = nums[j];
            update(1, 0, n - 1, last[v] + 1, j);
            last[v] = j;
            ans = (ans + sq[1]) % MOD;
        }
        return (int) ans;
    }
}