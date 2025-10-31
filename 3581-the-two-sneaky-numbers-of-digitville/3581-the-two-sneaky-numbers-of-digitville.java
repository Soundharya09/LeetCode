class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i <= n-1; i++) {
            if(nums[i] == nums[i+1]) {
                ans[count++] = nums[i];
                i++;
            }
            if(count == 2) break;
        }
        return ans;
    }
}