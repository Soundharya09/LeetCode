class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return result;
        int start = 0;
        for (int i = 0; i <= n; i++) {
            if (i == n || (long) nums[i] != (long) nums[start] + (i - start)) {
                if (start == i - 1) result.add(String.valueOf(nums[start]));
                else result.add(nums[start] + "->" + nums[i - 1]);
                start = i;
            }
        }
        return result;
    }
}