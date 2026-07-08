class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1_000_000_007L;
        
        int[] posArr = new int[m];
        int[] digArr = new int[m];
        int k = 0;
        for (int i = 0; i < m; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                posArr[k] = i;
                digArr[k] = d;
                k++;
            }
        }
        
        long[] prefixMod = new long[k + 1];
        long[] prefixSum = new long[k + 1];
        long[] pow10 = new long[k + 1];
        pow10[0] = 1;
        for (int t = 1; t <= k; t++) {
            prefixMod[t] = (prefixMod[t - 1] * 10 + digArr[t - 1]) % MOD;
            prefixSum[t] = prefixSum[t - 1] + digArr[t - 1];
            pow10[t] = (pow10[t - 1] * 10) % MOD;
        }
        
        int q = queries.length;
        int[] result = new int[q];
        
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
            int lo = lowerBound(posArr, k, l);
            int hi = upperBound(posArr, k, r) - 1;
            
            if (lo > hi || lo >= k || hi < 0) {
                result[i] = 0;
                continue;
            }
            
            int count = hi - lo + 1;
            long x = ((prefixMod[hi + 1] - prefixMod[lo] * pow10[count]) % MOD + MOD) % MOD;
            long sum = (prefixSum[hi + 1] - prefixSum[lo]) % MOD;
            
            long ans = (x * sum) % MOD;
            result[i] = (int) ans;
        }
        return result;
    }
    
    public int lowerBound(int[] arr, int k, int target) {
        int left = 0, right = k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    
    public int upperBound(int[] arr, int k, int target) {
        int left = 0, right = k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}