class Solution {
    public boolean canFinish(long time, int mountainHeight, int[] workerTimes) {
        long totalReduce = 0;
        for(int wt : workerTimes) {
            long low = 0, high = mountainHeight;
            while(low < high) {
                long mid = (low + high + 1) / 2;
                if(cost(mid, wt) <= time) low = mid;
                else high = mid - 1;
            }
            totalReduce += low;
            if (totalReduce >= mountainHeight) return true;
        }
        return totalReduce >= mountainHeight;
    }
    public long cost(long x, long wt) {
        return wt * x * (x + 1) / 2;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 0, high = (long) 1e17;
        while(low < high) {
            long mid = low + (high - low) / 2;
            if(canFinish(mid, mountainHeight, workerTimes)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}