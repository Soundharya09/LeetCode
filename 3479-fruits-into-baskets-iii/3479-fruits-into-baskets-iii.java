class Solution {
    private int[] tree;
    private int n;

    public void build(int[] baskets, int node, int start, int end) {
        if (start == end) tree[node] = baskets[start];
        else {
            int mid = (start + end) / 2;
            build(baskets, 2 * node, start, mid);
            build(baskets, 2 * node + 1, mid + 1, end);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }
    }
    public void update(int node, int start, int end, int idx) {
        if (start == end) tree[node] = 0;
        else {
            int mid = (start + end) / 2;
            if (idx <= mid) update(2 * node, start, mid, idx);
            else update(2 * node + 1, mid + 1, end, idx);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }
    }
    public int query(int node, int start, int end, int required) {
        if (tree[node] < required) return -1; 
        if (start == end) return start;
        int mid = (start + end) / 2;
        int leftResult = query(2 * node, start, mid, required);
        if (leftResult != -1) return leftResult;
        return query(2 * node + 1, mid + 1, end, required);
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        tree = new int[4 * n];
        build(baskets, 1, 0, n - 1);
        int unplaced = 0;
        for (int fruit : fruits) {
            int idx = query(1, 0, n - 1, fruit);
            if (idx == -1) unplaced++;
            else update(1, 0, n - 1, idx); 
        }
        return unplaced;
    }
}