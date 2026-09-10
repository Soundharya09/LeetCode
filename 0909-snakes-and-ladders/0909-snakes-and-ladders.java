class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] cells = new int[n * n + 1];
        int label = 1;
        int row = n - 1;
        boolean leftToRight = true;

        while (row >= 0) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    cells[label++] = board[row][col];
                }
            } 
            else {
                for (int col = n - 1; col >= 0; col--) {
                    cells[label++] = board[row][col];
                }
            }
            leftToRight = !leftToRight;
            row--;
        }

        int target = n * n;
        boolean[] visited = new boolean[target + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == target) return moves;

                for (int next = curr + 1; next <= Math.min(curr + 6, target); next++) {
                    int dest = cells[next] == -1 ? next : cells[next];
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}