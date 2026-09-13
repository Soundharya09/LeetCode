class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
            }
        }
        
        Map<String, Integer> map = new HashMap<>();
        int maxOverlap = 0;
        
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                String key = dx + "," + dy;
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        return maxOverlap;
    }
}