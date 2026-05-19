class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        for(int num : nums1) {
            ans.add(num);
        }
        for(int num : nums2) {
            if(ans.contains(num)) return num;
        }
        return -1;
    }
}