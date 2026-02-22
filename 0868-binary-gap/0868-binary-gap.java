class Solution {
    public int binaryGap(int n) {
        int max = 0, i = 0;
        int last = Integer.MAX_VALUE;
        while(n != 0) {
            if((n & 1) == 1) {
                if(i - last > max) max = i - last;
                last = i;
            }
            n >>= 1;
            i++;
        }
        return max;
    }
}