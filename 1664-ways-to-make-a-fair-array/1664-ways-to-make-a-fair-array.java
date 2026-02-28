class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        long[] evenPrefix = new long[n + 1];
        long[] oddPrefix = new long[n + 1];
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                evenPrefix[i + 1] = evenPrefix[i] + nums[i];
                oddPrefix[i + 1] = oddPrefix[i];
            }
            else {
                evenPrefix[i + 1] = evenPrefix[i];
                oddPrefix[i + 1] = oddPrefix[i] + nums[i];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            long evenBefore = evenPrefix[i];
            long oddBefore = oddPrefix[i];
            long evenAfter = oddPrefix[n] - oddPrefix[i + 1];
            long oddAfter = evenPrefix[n] - evenPrefix[i + 1];

            if(evenBefore + evenAfter == oddBefore + oddAfter) count++;
        }
        return count;
    }
}