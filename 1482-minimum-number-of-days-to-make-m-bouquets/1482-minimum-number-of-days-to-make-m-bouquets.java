class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long total = (long) m * k;
        if (total > bloomDay.length) return -1;
        int left = 1, right = 1_000_000_000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(bloomDay, m, k, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    public boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, consecutive = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;
                }
            }
            else consecutive = 0;
        }
        return bouquets >= m;
    }
}