class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for(int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }
        int[] count = new int[maxCost + 1];
        for(int cost : costs) {
            count[cost]++;
        }
        int res = 0;
        for (int cost = 1; cost <= maxCost && coins > 0; cost++) {
            if (count[cost] == 0) continue;
            int numCanBuy = Math.min(count[cost], coins / cost);
            res += numCanBuy;
            coins -= numCanBuy * cost;
        }
        return res;
    }
}