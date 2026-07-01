class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        int[][] safeness = new int[n][n];
        for (int[] row : safeness) Arrays.fill(row, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); 
        safeness[0][0] = dist[0][0];
        pq.offer(new int[]{dist[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int safe = cur[0], r = cur[1], c = cur[2];
            if (safe < safeness[r][c]) continue; 
            if (r == n - 1 && c == n - 1) return safe;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int newSafe = Math.min(safe, dist[nr][nc]);
                    if (newSafe > safeness[nr][nc]) {
                        safeness[nr][nc] = newSafe;
                        pq.offer(new int[]{newSafe, nr, nc});
                    }
                }
            }
        }
        return safeness[n - 1][n - 1];
    }
}