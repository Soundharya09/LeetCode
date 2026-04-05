class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        Map<Integer, List<long[]>> graph = new HashMap<>();
        Map<Integer, List<long[]>> revGraph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            long w = edge[2];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new long[]{v, w});
            revGraph.computeIfAbsent(v, x -> new ArrayList<>()).add(new long[]{u, w});
        }
        long[] d1 = dijkstra(src1, n, graph);   
        long[] d2 = dijkstra(src2, n, graph);   
        long[] d3 = dijkstra(dest, n, revGraph); 
        long ans = Long.MAX_VALUE;
        for (int m = 0; m < n; m++) {
            if (d1[m] == Long.MAX_VALUE || d2[m] == Long.MAX_VALUE ||
                d3[m] == Long.MAX_VALUE) continue;
            ans = Math.min(ans, d1[m] + d2[m] + d3[m]);
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }
    public long[] dijkstra(int src, int n, Map<Integer, List<long[]>> graph) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, src});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];
            if (d > dist[node]) continue; 
            if (!graph.containsKey(node)) continue;
            for (long[] neighbor : graph.get(node)) {
                int next = (int) neighbor[0];
                long weight = neighbor[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new long[]{dist[next], next});
                }
            }
        }
        return dist;
    }
}