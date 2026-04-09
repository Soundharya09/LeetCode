class Graph {
    private int n;
    private Map<Integer, List<int[]>> adj;

    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        for (int[] e : edges) adj.get(e[0]).add(new int[]{e[1], e[2]});
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, node1});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1];
            if (cost > dist[node]) continue;
            if (node == node2) return cost;
            for (int[] next : adj.get(node)) {
                int newCost = cost + next[1];
                if (newCost < dist[next[0]]) {
                    dist[next[0]] = newCost;
                    pq.offer(new int[]{newCost, next[0]});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */