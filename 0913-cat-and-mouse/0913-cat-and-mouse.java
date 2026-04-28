class Solution {
    static final int DRAW = 0, MOUSE_WIN = 1, CAT_WIN = 2;
    static final int MOUSE_TURN = 0, CAT_TURN = 1;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] color = new int[n][n][2];
        int[][][] degree = new int[n][n][2];
        for (int m = 0; m < n; m++) {
            for (int c = 0; c < n; c++) {
                degree[m][c][MOUSE_TURN] = graph[m].length;
                degree[m][c][CAT_TURN] = graph[c].length;
                for (int next : graph[c]) {
                    if (next == 0) {
                        degree[m][c][CAT_TURN]--;
                        break;
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int t = 0; t < 2; t++) {
                if (i != 0) {
                    color[0][i][t] = MOUSE_WIN;
                    queue.offer(new int[]{0, i, t});
                }
                if (i != 0) {
                    color[i][i][t] = CAT_WIN;
                    queue.offer(new int[]{i, i, t});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int mouse = state[0], cat = state[1], turn = state[2];
            int result = color[mouse][cat][turn];
            int prevTurn = 1 - turn;
            if (prevTurn == MOUSE_TURN) {
                for (int prevMouse : graph[mouse]) {
                    if (color[prevMouse][cat][MOUSE_TURN] != DRAW) continue;
                    if (result == MOUSE_WIN) {
                        color[prevMouse][cat][MOUSE_TURN] = MOUSE_WIN;
                        queue.offer(new int[]{prevMouse, cat, MOUSE_TURN});
                    } 
                    else if (result == CAT_WIN) {
                        degree[prevMouse][cat][MOUSE_TURN]--;
                        if (degree[prevMouse][cat][MOUSE_TURN] == 0) {
                            color[prevMouse][cat][MOUSE_TURN] = CAT_WIN;
                            queue.offer(new int[]{prevMouse, cat, MOUSE_TURN});
                        }
                    }
                }
            }
            else {
                for (int prevCat : graph[cat]) {
                    if (prevCat == 0) continue;
                    if (color[mouse][prevCat][CAT_TURN] != DRAW) continue;
                    if (result == CAT_WIN) {
                        color[mouse][prevCat][CAT_TURN] = CAT_WIN;
                        queue.offer(new int[]{mouse, prevCat, CAT_TURN});
                    } 
                    else if (result == MOUSE_WIN) {
                        degree[mouse][prevCat][CAT_TURN]--;
                        if (degree[mouse][prevCat][CAT_TURN] == 0) {
                            color[mouse][prevCat][CAT_TURN] = MOUSE_WIN;
                            queue.offer(new int[]{mouse, prevCat, CAT_TURN});
                        }
                    }
                }
            }
        }
        return color[1][2][MOUSE_TURN];
    }
}