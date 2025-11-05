class Solution {
    public double power(double x, long n) {
        double res = 1.0;
        while(n > 0) {
            if((n & 1) == 1) res *= x;
            x *= x;
            n >>>= 1;
        }
        return res;
    }
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        long N = n;  
        if (N < 0) {
            x = 1.0 / x;
            N = -N; 
        }
        return power(x, N);
    }
}