class Solution {
    int k;
    int[] treeProd;
    int[][] treeM;

    static class Pair {
        int prod;
        int[] M;
        Pair(int prod, int[] M) {
            this.prod = prod;
            this.M = M;
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        int n = nums.length;
        treeProd = new int[4 * n];
        treeM = new int[4 * n][k * k];
        build(1, 0, n - 1, nums);

        int q = queries.length;
        int[] res = new int[q];
        int startRem = 1 % k;
        for (int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            update(1, 0, n - 1, idx, val);
            Pair r = query(1, 0, n - 1, start, n - 1);
            res[i] = r.M[startRem * k + x];
        }
        return res;
    }
    
    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            setLeaf(node, nums[l]);
            return;
        }
        int mid = (l + r) / 2;
        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);
        pull(node);
    }

    private void setLeaf(int node, int val) {
        int v = val % k;
        treeProd[node] = v;
        int[] m = treeM[node];
        Arrays.fill(m, 0);
        for (int r = 0; r < k; r++) {
            int x = (r * v) % k;
            m[r * k + x] = 1;
        }
    }

    private void pull(int node) {
        int left = node * 2, right = node * 2 + 1;
        int prodL = treeProd[left], prodR = treeProd[right];
        treeProd[node] = (prodL * prodR) % k;
        int[] ML = treeM[left], MR = treeM[right];
        int[] res = treeM[node];
        for (int r = 0; r < k; r++) {
            int rr = (r * prodL) % k;
            for (int x = 0; x < k; x++) {
                res[r * k + x] = ML[r * k + x] + MR[rr * k + x];
            }
        }
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            setLeaf(node, val);
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) update(node * 2, l, mid, idx, val);
        else update(node * 2 + 1, mid + 1, r, idx, val);
        pull(node);
    }

    private Pair query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return new Pair(treeProd[node], treeM[node]);
        }
        int mid = (l + r) / 2;
        if (qr <= mid) return query(node * 2, l, mid, ql, qr);
        if (ql > mid) return query(node * 2 + 1, mid + 1, r, ql, qr);
        Pair L = query(node * 2, l, mid, ql, qr);
        Pair R = query(node * 2 + 1, mid + 1, r, ql, qr);
        return merge(L, R);
    }

    private Pair merge(Pair L, Pair R) {
        int prod = (L.prod * R.prod) % k;
        int[] m = new int[k * k];
        for (int r = 0; r < k; r++) {
            int rr = (r * L.prod) % k;
            for (int x = 0; x < k; x++) {
                m[r * k + x] = L.M[r * k + x] + R.M[rr * k + x];
            }
        }
        return new Pair(prod, m);
    }
}