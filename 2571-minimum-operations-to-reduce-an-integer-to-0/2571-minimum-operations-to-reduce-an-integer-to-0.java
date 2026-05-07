class Solution {
    public int minOperations(int n) {
       int ops = 0;
        while (n != 0) {
            if ((n & 1) == 0) n >>= 1;
            else if ((n & 3) == 3) {
                n++;
                ops++;
            } 
            else {
                n--;
                ops++;
            }
        }
        return ops;
    }
}