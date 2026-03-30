class Solution {
    int[] values;
    List<int[]>[] graph;
    int maxTime, ans = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        this.maxTime = maxTime;
        int n = values.length;
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, 0, values[0], visited);
        return ans;
    }
    public void dfs(int node, int time, int quality, boolean[] visited) {
        if (node == 0) ans = Math.max(ans, quality);
        for (int[] next : graph[node]) {
            int nb = next[0], t = next[1];
            if (time + t > maxTime) continue;
            boolean seen = visited[nb];
            visited[nb] = true;
            dfs(nb, time + t, quality + (seen ? 0 : values[nb]), visited);
            visited[nb] = seen;
        }
    }
}