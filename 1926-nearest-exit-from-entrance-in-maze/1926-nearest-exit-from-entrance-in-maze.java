class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] d : dirs) {
                    int r = cur[0] + d[0];
                    int c = cur[1] + d[1];
                    if (r < 0 || c < 0 || r >= m || c >= n || maze[r][c] == '+') {
                        continue;
                    }
                    if (r == 0 || c == 0 || r == m - 1 || c == n - 1) return steps;
                    maze[r][c] = '+';
                    queue.offer(new int[]{r, c});
                }
            }
        }
        return -1;
    }
}