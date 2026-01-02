class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for(int num : nums) {
            if(ans.contains(num)) return num;
            ans.add(num);
        }
        return 0;
    }
}