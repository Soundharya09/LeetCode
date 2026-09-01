class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startX = -1, startY = -1;
        List<int[]> litters = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } 
                else if (c == 'L') litters.add(new int[]{i, j});
            }
        }
        int numLitters = litters.size();
        if (numLitters == 0) return 0;
        
        int[][] litterPos = new int[numLitters][2];
        for (int i = 0; i < numLitters; i++) {
            litterPos[i] = litters.get(i);
        }
        int fullMask = (1 << numLitters) - 1;
        int[][][] bestEnergy = new int[m][n][1 << numLitters];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0, energy, 0});
        bestEnergy[startX][startY][0] = energy;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int mask = curr[2];
            int e = curr[3];
            int steps = curr[4];
            
            if (mask == fullMask) return steps;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                
                char cell = classroom[nx].charAt(ny);
                if (cell == 'X') continue;
                
                int newE = e - 1;
                int newMask = mask;
                
                if (newE < 0) continue;
                if (cell == 'R') newE = energy;
                if (cell == 'L') {
                    for (int i = 0; i < numLitters; i++) {
                        if (litterPos[i][0] == nx && litterPos[i][1] == ny) {
                            newMask |= (1 << i);
                            break;
                        }
                    }
                }
                if (newE <= bestEnergy[nx][ny][newMask]) continue;
                bestEnergy[nx][ny][newMask] = newE;
                queue.offer(new int[]{nx, ny, newMask, newE, steps + 1});
            }
        }
        return -1;
    }
}