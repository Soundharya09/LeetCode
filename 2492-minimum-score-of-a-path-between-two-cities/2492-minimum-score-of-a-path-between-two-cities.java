class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int minScore = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] neighbor : adj.get(node)) {
                int nextCity = neighbor[0];
                int dist = neighbor[1];
                minScore = Math.min(minScore, dist);
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }
        return minScore;
    }
}