class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long lo = 1, hi = (long) 25 * k;
        
        int m = 1 << n;
        long[] lcm = new long[m];
        int[] sign = new int[m];
        lcm[0] = 1;
        sign[0] = 0;
        
        for (int mask = 1; mask < m; mask++) {
            int lowBit = Integer.numberOfTrailingZeros(mask);
            long base = (mask & (mask - 1)) == 0 ? 1 : lcm[mask & (mask - 1)];
            lcm[mask] = lcmSafe(base, coins[lowBit]);
            sign[mask] = Integer.bitCount(mask) % 2 == 1 ? 1 : -1;
        }
        
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = countUpTo(mid, lcm, sign, m);
            if (count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    
    private long countUpTo(long x, long[] lcm, int[] sign, int m) {
        long count = 0;
        for (int mask = 1; mask < m; mask++) {
            if (lcm[mask] == -1 || lcm[mask] > x) continue;
            count += sign[mask] * (x / lcm[mask]);
        }
        return count;
    }
    
    private long lcmSafe(long a, long b) {
        long g = gcd(a, b);
        long result = a / g;
        if (result > Long.MAX_VALUE / b) return -1;
        return result * b;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}