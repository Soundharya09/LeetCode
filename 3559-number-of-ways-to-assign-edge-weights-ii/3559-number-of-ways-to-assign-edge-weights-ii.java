class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int LOG = 17; 
    private List<Integer>[] adj;
    private int[] depth;
    private int[][] up; 
    private int n;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        n = edges.length + 1;
        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        depth = new int[n + 1];
        up = new int[n + 1][LOG];
        bfs(1);
        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= n; v++) {
                up[v][k] = up[up[v][k - 1]][k - 1];
            }
        }
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u == v) {
                answer[i] = 0;
                continue;
            }
            int lca = lca(u, v);
            int k = depth[u] + depth[v] - 2 * depth[lca];
            answer[i] = (int) pow2[k - 1];
        }
        return answer;
    }

    public void bfs(int root) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
 
        queue.offer(root);
        visited[root] = true;
        depth[root] = 0;
        up[root][0] = root; 
 
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    depth[neighbor] = depth[node] + 1;
                    up[neighbor][0] = node; 
                    queue.offer(neighbor);
                }
            }
        }
    }

    public int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int tmp = u; 
            u = v; 
            v = tmp;
        }
        int diff = depth[u] - depth[v];
        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) == 1) u = up[u][k];
        }
        if (u == v) return u;
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[u][k] != up[v][k]) {
                u = up[u][k];
                v = up[v][k];
            }
        }
        return up[u][0];
    }
}