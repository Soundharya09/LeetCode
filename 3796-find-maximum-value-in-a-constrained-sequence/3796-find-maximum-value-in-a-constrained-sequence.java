class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        long[] maxAllow = new long[n];
        Arrays.fill(maxAllow, Long.MAX_VALUE);
        maxAllow[0] = 0;
        for(int[] r : restrictions) {
            int idx = r[0];
            int maxVal = r[1];
            maxAllow[idx] = Math.min(maxAllow[idx], maxVal);
        }
        for(int i = 1; i < n; i++) {
            maxAllow[i] = Math.min(maxAllow[i], maxAllow[i-1] + diff[i -1]);
        }
        for(int i = n - 2; i >= 0; i--) {
            maxAllow[i] = Math.min(maxAllow[i], maxAllow[i+1] + diff[i]);
        }
        long res = 0;
        for(long val : maxAllow) {
            res = Math.max(res, val);
        }
        return (int) res;
    }
}