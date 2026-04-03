class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : redEdges)  adj.get(e[0]).add(new int[]{e[1], 0}); 
        for (int[] e : blueEdges) adj.get(e[0]).add(new int[]{e[1], 1}); 
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); 
        queue.offer(new int[]{0, 1}); 
        visited[0][0] = true;
        visited[0][1] = true;
        answer[0] = 0;
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int lastColor = curr[1];
                for (int[] next : adj.get(node)) {
                    int neighbor  = next[0];
                    int edgeColor = next[1];
                    if (edgeColor == lastColor) continue;
                    if (!visited[neighbor][edgeColor]) {
                        visited[neighbor][edgeColor] = true;
                        queue.offer(new int[]{neighbor, edgeColor});
                        if (answer[neighbor] == -1) answer[neighbor] = dist;
                    }
                }
            }
        }
        return answer;
    }
}