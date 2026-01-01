class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(citations[n - mid] >= mid) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}