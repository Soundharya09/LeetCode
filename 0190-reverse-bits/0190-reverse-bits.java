class Solution {
    public int reverse(int v, int len) {
        if(len == 1) return v & 1;

        int half = len >> 1;
        int mask = (1 << half) - 1;
        int low = v & mask;
        int high = v >>> half;

        int revLow = reverse(low, half);
        int revHigh = reverse(high, half);
        
        return (revLow << half) | revHigh;
    }
    public int reverseBits(int n) {
        return reverse(n, 32);
    }
}