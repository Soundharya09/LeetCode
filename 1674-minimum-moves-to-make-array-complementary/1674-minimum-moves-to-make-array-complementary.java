class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            int lo = Math.min(a, b);
            int hi = Math.max(a, b);
            diff[lo + 1] -= 1;
            diff[hi + limit + 1] += 1;
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
        }
        int baseCost = (n / 2) * 2;
        int minMoves = baseCost;
        int current = baseCost;
        for (int x = 2; x <= 2 * limit; x++) {
            current += diff[x];
            minMoves = Math.min(minMoves, current);
        }
        return minMoves;
    }
}