class Solution {
    public int countQuadruplets(int[] nums) {
        int count = 0; int n = nums.length;
        for(int a = 0; a < n; a++) {
            for(int b = a+1; b < n; b++) {
                for(int c = b+1; c < n; c++) {
                    for(int d = c+1; d < n; d++) {
                        if(nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}