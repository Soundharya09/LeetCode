class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;
        for (int p : piles) {
            hi = Math.max(hi, p);
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(piles, h, mid)) hi = mid;      
            else lo = mid + 1;   
        }
        return lo;
    }
    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0; 
        for (int p : piles) {
            hours += (p + k - 1) / k; 
            if (hours > h) return false;
        }
        return true;
    }
}