class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<int[]> filtered = new ArrayList<>();
        for (int[] e : edges) {
            if (online[e[0]] && online[e[1]]) filtered.add(e);
        }
        if (filtered.isEmpty()) return -1;
        int fm = filtered.size();
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] nxt = new int[fm];
        int[] to = new int[fm];
        long[] w = new long[fm];
        int idx = 0;
        int[] indeg2 = new int[n];
        for (int[] e : filtered) {
            int u = e[0], v = e[1];
            to[idx] = v;
            w[idx] = e[2];
            nxt[idx] = head[u];
            head[u] = idx;
            idx++;
            indeg2[v]++;
        }
        int[] topo = new int[n];
        int ti = 0;
        int[] queue = new int[n];
        int qh = 0, qt = 0;
        for (int i = 0; i < n; i++) if (indeg2[i] == 0) queue[qt++] = i;
        while (qh < qt) {
            int u = queue[qh++];
            topo[ti++] = u;
            for (int e = head[u]; e != -1; e = nxt[e]) {
                int v = to[e];
                if (--indeg2[v] == 0) queue[qt++] = v;
            }
        }
        long[] costs = new long[fm];
        for (int i = 0; i < fm; i++) costs[i] = w[i];
        Arrays.sort(costs);
        int distinctCount = 0;
        for (int i = 0; i < fm; i++) {
            if (i == 0 || costs[i] != costs[distinctCount - 1]) costs[distinctCount++] = costs[i];
        }
        final long INF = Long.MAX_VALUE / 2;
        long[] dist = new long[n];
        int lo = 0, hi = distinctCount - 1, best = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            long threshold = costs[mid];
            Arrays.fill(dist, INF);
            dist[0] = 0;
            for (int i = 0; i < ti; i++) {
                int u = topo[i];
                if (dist[u] == INF) continue;
                for (int e = head[u]; e != -1; e = nxt[e]) {
                    if (w[e] >= threshold) {
                        int v = to[e];
                        long nd = dist[u] + w[e];
                        if (nd < dist[v]) dist[v] = nd;
                    }
                }
            }
            if (dist[n - 1] <= k) {
                best = mid;
                lo = mid + 1;
            } 
            else hi = mid - 1;
        }
        return best == -1 ? -1 : (int) costs[best];
    }
}