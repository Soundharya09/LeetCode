class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for(int num : nums) {
            if(num % 2 == 0) ans[left++] = num;
            else ans[right--] = num;
        }
        return ans;
    }
}