class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }
        long[] sorted = pref.clone();
        Arrays.sort(sorted);
        int m = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) sorted[m++] = sorted[i];
        }
        int[] bit = new int[m + 2]; 
        long ans = 0;
        for (int j = 0; j <= n; j++) {
            int rank = lowerBound(sorted, m, pref[j]) + 1; 
            ans += query(bit, rank - 1);
            update(bit, rank, m);
        }
        return ans;
    }
    
    private int lowerBound(long[] arr, int len, long key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private void update(int[] bit, int i, int size) {
        for (; i <= size; i += i & (-i)) {
            bit[i]++;
        }
    }

    private int query(int[] bit, int i) {
        int sum = 0;
        for (; i > 0; i -= i & (-i)) {
            sum += bit[i];
        }
        return sum;
    }
}