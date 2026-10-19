class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // T.C. -> O(n log n), S.C. -> O(1)
        // Arrays.sort(nums);
        // List<Integer> ans = new ArrayList<>();
        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] == target) ans.add(i);
        // }
        // return ans;

        // T.C. -> O(n), S.C. -> O(1)
        int less = 0, equal = 0;
        for(int n : nums) {
            if(n < target) less++;
            else if(n == target) equal++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < equal; i++) {
            ans.add(less + i);
        }
        return ans;
    }
}