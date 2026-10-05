class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] c : connections) {
            graph[c[0]].add(new int[]{c[1], 1}); 
            graph[c[1]].add(new int[]{c[0], 0}); 
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        int changes = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] edge : graph[node]) {
                int next = edge[0];
                if (!visited[next]) {
                    visited[next] = true;
                    changes += edge[1];
                    queue.offer(next);
                }
            }
        }
        return changes;
    }
}