class Solution {
    public boolean isPossible(int c, int[] arr, int d) {
        int load = 0, days = 1;
        for(int i = 0; i < arr.length; i++) {
            if(load + arr[i] <= c) {
                load += arr[i];
            }
            else {
                load = arr[i];
                days++;
            }
        }
        if(days > d) return false;
        return true;
    }
    public int shipWithinDays(int[] arr, int d) {
        int n = arr.length;
        int sum = 0, mx = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            mx = Math.max(mx, arr[i]);
            sum += arr[i];
        }
        int low = mx, high = sum, minC = sum;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(mid, arr, d) == true) {
                minC = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return minC;
    }
}