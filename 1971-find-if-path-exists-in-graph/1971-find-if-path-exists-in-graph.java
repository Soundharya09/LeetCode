class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (neighbor == destination) return true;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }
}