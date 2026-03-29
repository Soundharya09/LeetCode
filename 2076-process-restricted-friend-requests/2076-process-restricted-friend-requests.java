class Solution {
    private int[] parent, rank;
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean[] result = new boolean[requests.length];
        for (int j = 0; j < requests.length; j++) {
            int u = requests[j][0], v = requests[j][1];
            int ru = find(u), rv = find(v);
            if (ru == rv) {
                result[j] = true;
                continue;
            }
            boolean allowed = true;
            for (int[] r : restrictions) {
                int rx = find(r[0]), ry = find(r[1]);
                if ((ru == rx && rv == ry) || (ru == ry && rv == rx)) {
                    allowed = false;
                    break;
                }
            }
            if (allowed) {
                union(ru, rv);
                result[j] = true;
            }
        }
        return result;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;
        if (rank[ra] < rank[rb]) parent[ra] = rb;
        else if (rank[ra] > rank[rb]) parent[rb] = ra;
        else { parent[rb] = ra; rank[ra]++; }
    }
}