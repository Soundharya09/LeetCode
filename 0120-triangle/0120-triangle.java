class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        List<Integer> lastRow = triangle.get(n - 1);
        for(int i = 0; i < n; i++) {
            dp[i] = lastRow.get(i);
        }
        for(int row = n - 2; row >= 0; row--) {
            List<Integer> currRow = triangle.get(row);
            for(int i = 0; i <= row; i++) {
                dp[i] = currRow.get(i) + Math.min(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }
}