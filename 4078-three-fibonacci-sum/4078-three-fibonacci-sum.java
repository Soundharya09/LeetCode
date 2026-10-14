class Solution {
    public boolean threeFibonacciSum(int n) {
        long a = 0, b = 1;
        while(a <= n) {
            if(a + b + (a + b) == n) return true;
            long next = a + b;
            a = b;
            b = next;
        }
        return false;
    }
}