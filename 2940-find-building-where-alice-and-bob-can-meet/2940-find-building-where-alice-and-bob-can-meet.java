class Solution {
    private int[] segmentTree;
    private int n;

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        n = heights.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(heights, 1, 0, n - 1);
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a == b) {
                ans[i] = a;
                continue;
            }
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (heights[a] < heights[b]) {
                ans[i] = b;
                continue;
            }
            int requiredHeight = heights[a];
            int result = query(heights, 1, 0, n - 1, b + 1, n - 1, requiredHeight);
            ans[i] = result;
        }
        return ans;
    }
    public void buildSegmentTree(int[] heights, int node, int left, int right) {
        if (left == right) {
            segmentTree[node] = heights[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildSegmentTree(heights, node * 2, left, mid);
        buildSegmentTree(heights, node * 2 + 1, mid + 1, right);
        segmentTree[node] = Math.max(segmentTree[node * 2], segmentTree[node * 2 + 1]);
    }
    public int query(int[] heights, int node, int left, int right, int qLeft, int qRight, int target) {
        if (left > qRight || right < qLeft || segmentTree[node] <= target) return -1;
        if (left == right) return left;
        int mid = left + (right - left) / 2;
        int leftResult = query(heights, node * 2, left, mid, qLeft, qRight, target);
        if (leftResult != -1) return leftResult;
        return query(heights, node * 2 + 1, mid + 1, right, qLeft, qRight, target);
    }
}