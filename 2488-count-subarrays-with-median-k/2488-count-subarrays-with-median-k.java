class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) { kIdx = i; break; }
        }
        
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int balance = 0;
        
        for (int i = kIdx - 1; i >= 0; i--) {
            balance += nums[i] > k ? 1 : -1;
            prefixCount.put(balance, prefixCount.getOrDefault(balance, 0) + 1);
        }
        
        int result = prefixCount.getOrDefault(0, 0) + prefixCount.getOrDefault(1, 0);
        balance = 0;
        
        for (int i = kIdx + 1; i < n; i++) {
            balance += nums[i] > k ? 1 : -1;
            result += prefixCount.getOrDefault(-balance, 0) + prefixCount.getOrDefault(1 - balance, 0);
        }
        return result;
    }
}