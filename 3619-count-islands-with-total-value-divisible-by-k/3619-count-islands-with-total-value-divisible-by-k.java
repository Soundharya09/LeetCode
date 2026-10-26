class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dirs = {0, 1, 0, -1, 0};
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long sum = 0;
                    Deque<int[]> stack = new ArrayDeque<>();
                    stack.push(new int[]{i, j});
                    visited[i][j] = true;

                    while (!stack.isEmpty()) {
                        int[] cur = stack.pop();
                        int r = cur[0], c = cur[1];
                        sum += grid[r][c];

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dirs[d], nc = c + dirs[d + 1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n
                                    && grid[nr][nc] > 0 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                stack.push(new int[]{nr, nc});
                            }
                        }
                    }
                    if (sum % k == 0) count++;
                }
            }
        }
        return count;
    }
}