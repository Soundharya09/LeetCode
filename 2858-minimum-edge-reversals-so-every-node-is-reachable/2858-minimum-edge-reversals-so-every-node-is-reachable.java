class Solution {
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], 0});
            adj[edge[1]].add(new int[]{edge[0], 1});
        }

        int[] dp = new int[n];
        boolean[] visited = new boolean[n];

        dfs(0, adj, dp, visited);

        int[] answer = new int[n];
        answer[0] = dp[0];

        visited = new boolean[n];
        rerooting(0, adj, dp, answer, visited);

        return answer;
    }
    public void dfs(int node, List<int[]>[] adj, int[] dp, boolean[] visited) {
        visited[node] = true;
        for (int[] neighbor : adj[node]) {
            int next = neighbor[0];
            int cost = neighbor[1];
            if (!visited[next]) {
                dfs(next, adj, dp, visited);
                dp[node] += dp[next] + cost;
            }
        }
    }
    public void rerooting(int node, List<int[]>[] adj, int[] dp, int[] answer, boolean[] visited) {
        visited[node] = true;
        for (int[] neighbor : adj[node]) {
            int next = neighbor[0];
            int cost = neighbor[1];
            if (!visited[next]) {
                answer[next] = answer[node] + (cost == 0 ? 1 : -1);
                rerooting(next, adj, dp, answer, visited);
            }
        }
    }
}