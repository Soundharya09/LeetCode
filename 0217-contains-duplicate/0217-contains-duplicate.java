class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Method 1 -> Hash Table
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0; i<nums.length; i++){
        //     if(set.contains(nums[i])) return true;
        //     else set.add(nums[i]);
        // }
        // return false;

        // Method 2 -> Arrays
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] == nums[i]) return true;
        }
        return false;
    }
}