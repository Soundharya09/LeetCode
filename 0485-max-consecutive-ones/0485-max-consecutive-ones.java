class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, currCount = 0;
        for(int n : nums) {
            if(n == 1) {
                currCount++;
                maxCount = Math.max(maxCount, currCount);
            }
            else currCount = 0;
        }
        return maxCount;
    }
}