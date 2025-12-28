class Solution {
    public boolean checkDivisibility(int n) {
        int original = n, sum = 0, product = 1;
        while(n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return original % (sum + product) == 0;
    }
}