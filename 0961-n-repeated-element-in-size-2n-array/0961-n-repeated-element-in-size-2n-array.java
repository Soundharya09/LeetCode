class Solution {
    public int repeatedNTimes(int[] nums) {
        // Set<Integer> ans = new HashSet<>();
        // for(int num : nums) {
        //     if(ans.contains(num)) return num;
        //     ans.add(num);
        // }
        // return 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < 2*n; i++) {
            if(nums[i] == nums[i+1]) return nums[i];
        }
        return 0;
    }
}