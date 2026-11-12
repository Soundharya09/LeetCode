class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long common = Math.min(need1, need2);
        long pairCost = Math.min((long) costBoth, (long) cost1 + cost2);

        long total = common * pairCost;

        long rem1 = need1 - common;
        long rem2 = need2 - common;

        total += rem1 * Math.min(cost1, costBoth);
        total += rem2 * Math.min(cost2, costBoth);

        return total;
    }
}