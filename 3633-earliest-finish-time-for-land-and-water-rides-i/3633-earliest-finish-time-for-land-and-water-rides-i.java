class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length, m = waterStartTime.length;
        int result = Integer.MAX_VALUE;
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int landEnd = landStartTime[i] + landDuration[i];
                int waterStart = Math.max(landEnd, waterStartTime[j]);
                int waterEnd = waterStart + waterDuration[j];
                result = Math.min(result, waterEnd);

                int waterEnd2 = waterStartTime[j] + waterDuration[j];
                int landStart2 = Math.max(waterEnd2, landStartTime[i]);
                int landEnd2 = landStart2 + landDuration[i];
                result = Math.min(result, landEnd2);
            }
        }
        return result;
    }
}