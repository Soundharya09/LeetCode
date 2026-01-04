class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long distinctSum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++) {
            int val = nums[right];
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            if(freq.get(val) == 1) distinctSum += val;
            while(distinctSum >= k) {
                ans = Math.min(ans, right - left + 1);
                int removeVal = nums[left];
                int count = freq.get(removeVal);
                if(count == 1) {
                    freq.remove(removeVal);
                    distinctSum -= removeVal;
                }
                else freq.put(removeVal, count - 1);
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}