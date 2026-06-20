class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }
        list.add(new int[]{1, 0});
        boolean hasN = false;
        for (int[] r : restrictions) {
            if (r[0] == n) {
                hasN = true;
                break;
            }
        }
        if (!hasN) list.add(new int[]{n, n - 1});
        list.sort((a, b) -> a[0] - b[0]);
        
        int size = list.size();
        int[][] arr = list.toArray(new int[0][]);
        for (int i = 1; i < size; i++) {
            int prevId = arr[i - 1][0];
            int prevH = arr[i - 1][1];
            int curId = arr[i][0];
            int curH = arr[i][1];
            int maxAllowed = prevH + (curId - prevId);
            arr[i][1] = Math.min(curH, maxAllowed);
        }
        for (int i = size - 2; i >= 0; i--) {
            int nextId = arr[i + 1][0];
            int nextH = arr[i + 1][1];
            int curId = arr[i][0];
            int curH = arr[i][1];
            int maxAllowed = nextH + (nextId - curId);
            arr[i][1] = Math.min(curH, maxAllowed);
        }
        int ans = 0;
        for (int i = 0; i < size; i++) {
            ans = Math.max(ans, arr[i][1]);
        }
        
        for (int i = 1; i < size; i++) {
            int id1 = arr[i - 1][0];
            int h1 = arr[i - 1][1];
            int id2 = arr[i][0];
            int h2 = arr[i][1];
            
            int dist = id2 - id1;
            int peak = (h1 + h2 + dist) / 2;
            ans = Math.max(ans, peak);
        }
        return ans;
    }
}