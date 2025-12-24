class Solution {
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        long count = 0, factor = 1;
        while(factor <= n) {
            long nextFactor = factor * 10;
            long higher = n / nextFactor;
            long current = (n / factor) % 10;
            long lower = n % factor;

            if(current > 1) count += (higher + 1) * factor;
            else if(current == 1) count += higher * factor + (lower + 1);
            else count += higher * factor;
            factor = nextFactor;
        }
        return (int) count;
    }
}