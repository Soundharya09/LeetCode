class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) g[e[0]].add(new int[]{e[1], e[2]});

        int W = k + 1;
        int[] dist = new int[n * W];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        dist[0 * W + 1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1], c = cur[2];

            if (d > dist[u * W + c]) continue;
            if (u == n - 1) return d;
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                int nc = (labels.charAt(u) == labels.charAt(v)) ? c + 1 : 1;
                if (nc > k) continue;

                int nd = d + w;
                int idx = v * W + nc;
                if (nd < dist[idx]) {
                    dist[idx] = nd;
                    pq.offer(new int[]{nd, v, nc});
                }
            }
        }
        return -1;
    }
}