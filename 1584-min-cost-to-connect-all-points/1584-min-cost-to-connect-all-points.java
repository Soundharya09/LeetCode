class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 0;
        int[] dist = new int[n];
        boolean[] inMST = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int totalCost = 0;
        for (int iter = 0; iter < n; iter++) {
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            inMST[u] = true;
            totalCost += dist[u];
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int cost = Math.abs(points[u][0] - points[v][0])
                             + Math.abs(points[u][1] - points[v][1]);
                    if (cost < dist[v]) dist[v] = cost;
                }
            }
        }
        return totalCost;
    }
}