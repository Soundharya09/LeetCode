class Solution {
    static class LazySegmentTree {
        int[] min, max, lazy;
        int n;
        
        LazySegmentTree(int n) {
            this.n = n;
            min = new int[4 * n];
            max = new int[4 * n];
            lazy = new int[4 * n];
        }
        
        void push(int node, int l, int r) {
            if (lazy[node] != 0) {
                min[node] += lazy[node];
                max[node] += lazy[node];
                if (l != r) {
                    lazy[2 * node] += lazy[node];
                    lazy[2 * node + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }
        
        void update(int ql, int qr, int val) {
            update(1, 0, n - 1, ql, qr, val);
        }
        
        void update(int node, int l, int r, int ql, int qr, int val) {
            push(node, l, r);
            if (qr < l || ql > r) return;
            if (ql <= l && r <= qr) {
                lazy[node] += val;
                push(node, l, r);
                return;
            }
            int mid = (l + r) / 2;
            update(2 * node, l, mid, ql, qr, val);
            update(2 * node + 1, mid + 1, r, ql, qr, val);
            push(2 * node, l, mid);
            push(2 * node + 1, mid + 1, r);
            min[node] = Math.min(min[2 * node], min[2 * node + 1]);
            max[node] = Math.max(max[2 * node], max[2 * node + 1]);
        }
        
        int findZero(int ql, int qr) {
            return findZero(1, 0, n - 1, ql, qr);
        }
        
        int findZero(int node, int l, int r, int ql, int qr) {
            push(node, l, r);
            if (qr < l || ql > r || min[node] > 0 || max[node] < 0) return -1;
            if (l == r) return (min[node] == 0) ? l : -1;
            int mid = (l + r) / 2;
            int right = findZero(2 * node + 1, mid + 1, r, ql, qr);
            if (right != -1) return right;
            return findZero(2 * node, l, mid, ql, qr);
        }
    }
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        LazySegmentTree tree = new LazySegmentTree(n);
        for (Map.Entry<Integer, List<Integer>> entry : pos.entrySet()) {
            int val = entry.getKey();
            int sign = (val % 2 == 1) ? 1 : -1;
            int p = entry.getValue().get(0);
            tree.update(p, n - 1, sign);
        }
        int ans = 0;
        for (int l = 0; l < n; l++) {
            int r = tree.findZero(l, n - 1);
            if (r != -1) ans = Math.max(ans, r - l + 1);
            List<Integer> positions = pos.get(nums[l]);
            positions.remove(0);
            int sign = (nums[l] % 2 == 1) ? 1 : -1;
            int next = positions.isEmpty() ? n : positions.get(0);
            if (next > l) tree.update(l, next - 1, -sign);
        }
        return ans;
    }
}