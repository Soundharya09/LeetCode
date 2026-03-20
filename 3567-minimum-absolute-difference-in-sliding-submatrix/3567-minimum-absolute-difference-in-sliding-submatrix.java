class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int rows = m - k + 1, cols = n - k + 1;
        int[][] ans = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                List<Integer> vals = new ArrayList<>();
                for(int x = i; x < i + k; x++) {
                    for(int y = j; y < j + k; y++) {
                        vals.add(grid[x][y]);
                    }
                }
                Collections.sort(vals);
                int minDiff = Integer.MAX_VALUE;
                for(int p = 1; p < vals.size(); p++) {
                    int diff = (int)vals.get(p) - (int)vals.get(p - 1);
                    if(diff > 0) minDiff = Math.min(minDiff, diff);
                }
                ans[i][j] = minDiff == Integer.MAX_VALUE ? 0 : minDiff;
            }
        }
        return ans;
    }
}