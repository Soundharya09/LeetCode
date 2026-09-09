class Solution {
    public long countCommas(long n) {
        long total = 0;
        long lower = 1;
        for (int d = 1; d <= 16; d++) {
            long upper = lower * 10 - 1;
            if (lower > n) break;
            long hi = Math.min(upper, n);
            long count = hi - lower + 1;
            int commas = (d - 1) / 3;
            total += count * commas;
            lower = upper + 1;
        }
        return total;
    }
}