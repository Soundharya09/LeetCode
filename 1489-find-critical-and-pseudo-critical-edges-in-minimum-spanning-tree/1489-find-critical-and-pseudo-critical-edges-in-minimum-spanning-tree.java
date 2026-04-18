class Solution {
    int[] parent, rank;
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (rank[px] < rank[py]) { int t = px; px = py; py = t; }
        parent[py] = px;
        if (rank[px] == rank[py]) rank[px]++;
        return true;
    }
    int buildMST(int n, int[][] edges, int skip, int forceEdge) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int weight = 0, edgesUsed = 0;
        if (forceEdge != -1) {
            int[] e = edges[forceEdge];
            union(e[0], e[1]);
            weight += e[2];
            edgesUsed++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == skip || i == forceEdge) continue;
            int[] e = edges[i];
            if (union(e[0], e[1])) {
                weight += e[2];
                edgesUsed++;
            }
        }
        return edgesUsed == n - 1 ? weight : Integer.MAX_VALUE;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] indexedEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            indexedEdges[i][0] = edges[i][0];
            indexedEdges[i][1] = edges[i][1];
            indexedEdges[i][2] = edges[i][2];
            indexedEdges[i][3] = i;
        }
        Arrays.sort(indexedEdges, (a, b) -> a[2] - b[2]);
        int baseMST = buildMST(n, indexedEdges, -1, -1);
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int weightWithout = buildMST(n, indexedEdges, i, -1);
            if (weightWithout > baseMST) {
                critical.add(indexedEdges[i][3]);
                continue;
            }
            int weightWith = buildMST(n, indexedEdges, -1, i);
            if (weightWith == baseMST) {
                pseudoCritical.add(indexedEdges[i][3]);
            }
        }
        return Arrays.asList(critical, pseudoCritical);
    }
}