class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for(int i = 0; i <= nums.size() - 2 * k; i++) {
            boolean firstIncrease = true;
            boolean secondIncrease = true;
            for(int j = i+1; j < i+k; j++) {
                if(nums.get(j) <= nums.get(j-1)) {
                    firstIncrease = false;
                    break;
                }
            }
            if(firstIncrease) {
                for(int j = i+k+1; j < i+2*k; j++) {
                    if(nums.get(j) <= nums.get(j-1)) {
                        secondIncrease = false;
                        break;
                    }
                }
                if(secondIncrease) return true;
            }
        }
        return false;
    }
}