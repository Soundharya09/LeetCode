class Solution {
    public int hIndex(int[] citations) {
   //Approach - 1 -> Using for loop and sorting techniques, T.C. -> O(nlogn), S.C. -> O(1)
        //Approach - 2 -> Binary Search -> T.C. -> O(nlogn), S.C. -> O(1)
        // int n = citations.length;
        // Arrays.sort(citations);
        // int left = 0, right = n;
        // while(left < right) {
        //     int mid = left + (right - left + 1) / 2;
        //     if(citations[n - mid] >= mid) left = mid;
        //     else right = mid - 1;
        // }
        // return left;

        // Approach - 3 -> Using Count Sort -> T.C. -> O(n), S.C. -> O(n), But Optimal
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for(int c : citations) {
            if(c >= n) bucket[n]++;
            else bucket[c]++;
        }
        int total = 0;
        for(int i = n; i >= 0; i--) {
            total += bucket[i];
            if(total >= i) return i;
        }
        return 0;
    }
}