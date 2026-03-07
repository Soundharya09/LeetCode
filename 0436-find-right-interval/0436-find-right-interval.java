class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] sorted = new int[n][2];
        for(int i = 0; i  < n; i++) {
            sorted[i][0] = intervals[i][0];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int lo = 0, hi = n - 1, ans = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (sorted[mid][0] >= end) {
                    ans = sorted[mid][1];
                    hi = mid - 1;
                } 
                else lo = mid + 1;
            }
            res[i] = ans;
        }
        return res;
    }
}