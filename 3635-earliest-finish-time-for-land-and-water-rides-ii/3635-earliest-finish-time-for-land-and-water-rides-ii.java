class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(solve(landStartTime, landDuration, waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration, landStartTime, landDuration));
    }
    public int solve(int[] startA, int[] durA, int[] startB, int[] durB) {
        int n = startA.length, m = startB.length;
        Integer[] idxA = new Integer[n];
        for (int i = 0; i < n; i++) idxA[i] = i;
        Arrays.sort(idxA, (i, j) -> startA[i] - startA[j]);
        Integer[] idxB = new Integer[m];
        for (int i = 0; i < m; i++) idxB[i] = i;
        Arrays.sort(idxB, (i, j) -> startB[i] - startB[j]);

        int[] sortedStartB = new int[m];
        int[] sortedDurB   = new int[m];
        for (int i = 0; i < m; i++) {
            sortedStartB[i] = startB[idxB[i]];
            sortedDurB[i] = durB[idxB[i]];
        }
        int[] prefMinDur = new int[m];
        prefMinDur[0] = sortedDurB[0];
        for (int i = 1; i < m; i++) {
            prefMinDur[i] = Math.min(prefMinDur[i - 1], sortedDurB[i]);
        }
        int[] sufMinFinish = new int[m + 1];
        sufMinFinish[m] = Integer.MAX_VALUE;
        for (int i = m - 1; i >= 0; i--) {
            sufMinFinish[i] = Math.min(sufMinFinish[i + 1],sortedStartB[i] + sortedDurB[i]);
        }
        int ans = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            int sa = startA[idxA[a]];
            int da = durA[idxA[a]];
            int finish1 = sa + da; 
            int lo = 0, hi = m - 1, split = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (sortedStartB[mid] <= finish1) {
                    split = mid; 
                    lo = mid + 1; 
                }
                else hi = mid - 1;
            }
            if (split >= 0) ans = Math.min(ans, finish1 + prefMinDur[split]);
            if (split + 1 < m) ans = Math.min(ans, sufMinFinish[split + 1]);
        }
        return ans;
    }
}

