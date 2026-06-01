class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0, n = cost.length;
        for(int i = n - 1; i >= 0; i--) {
            int pos = n - 1 - i;
            if(pos % 3 != 2) total += cost[i];
        }
        return total;
    }
}