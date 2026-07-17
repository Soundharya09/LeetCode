class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }
        int[] cnt = new int[maxVal + 1];
        for (int g = 1; g <= maxVal; g++) {
            for (int multiple = g; multiple <= maxVal; multiple += g) {
                cnt[g] += freq[multiple];
            }
        }
        long[] pairsAtLeast = new long[maxVal + 1];
        for (int g = 1; g <= maxVal; g++) {
            long c = cnt[g];
            pairsAtLeast[g] = c * (c - 1) / 2;
        }
        long[] exact = new long[maxVal + 1];
        for (int g = maxVal; g >= 1; g--) {
            long subtract = 0;
            for (int multiple = 2 * g; multiple <= maxVal; multiple += g) {
                subtract += exact[multiple];
            }
            exact[g] = pairsAtLeast[g] - subtract;
        }
        long[] prefix = new long[maxVal + 1];
        for (int g = 1; g <= maxVal; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }
        int m = queries.length;
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            long target = queries[i] + 1;
            int lo = 1, hi = maxVal;
            int result = maxVal;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (prefix[mid] >= target) {
                    result = mid;
                    hi = mid - 1;
                } 
                else lo = mid + 1;
            }
            answer[i] = result;
        }
        return answer;
    }
}