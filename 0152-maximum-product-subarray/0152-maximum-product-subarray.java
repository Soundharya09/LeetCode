class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0], minSoFar = nums[0], result   = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            int tempMin = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));

            maxSoFar = tempMax;
            minSoFar = tempMin;

            result = Math.max(result, maxSoFar);
        }
        return result;
    }
}