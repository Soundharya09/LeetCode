class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        final int MOD = 1_000_000_007;
        long totalSum = 0;
        for (int num : arr) totalSum += num;
        long maxOne = kadane(arr, arr.length);
        if (k == 1) return (int)(maxOne % MOD);
        long maxTwo = kadane(arr, 2 * arr.length);
        if (totalSum > 0) return (int)((maxTwo + (k - 2) * totalSum) % MOD);
        else return (int)(maxTwo % MOD);
    }
    public long kadane(int[] arr, int length) {
        long maxSum = 0; 
        long currentSum = 0;
        for (int i = 0; i < length; i++) {
            currentSum += arr[i % arr.length];
            if (currentSum < 0) currentSum = 0;
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}