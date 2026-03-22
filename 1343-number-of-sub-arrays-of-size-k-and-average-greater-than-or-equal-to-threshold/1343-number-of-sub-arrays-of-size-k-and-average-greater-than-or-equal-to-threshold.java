class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0, sum = 0, minSum = k * threshold;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if(sum >= minSum) count++;
        for(int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            if(sum >= minSum) count++;
        }
        return count;
    }
}