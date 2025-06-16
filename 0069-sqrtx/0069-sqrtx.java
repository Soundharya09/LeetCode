class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;
        if(x == 0) return 0;
        if(x == 1) return 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(mid == x/mid) return mid;
            else if(mid > x/mid) high = mid - 1;
            else low = mid + 1;
        }
        return high;
    }
}