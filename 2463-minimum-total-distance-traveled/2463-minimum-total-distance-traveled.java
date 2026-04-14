class Solution {
    private long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }
        int n = robot.size();
        int m = factoryPositions.size();
        dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return calculateMinDistance(0, 0, robot, factoryPositions);
    }

    public long calculateMinDistance(int robotIdx,int factoryIdx,List<Integer> robot,List<Integer> factoryPositions) {
        if (robotIdx == robot.size()) return 0;
        if (factoryIdx == factoryPositions.size()) return (long) 1e12;
        if (dp[robotIdx][factoryIdx] != -1) return dp[robotIdx][factoryIdx];
        long assign = Math.abs(robot.get(robotIdx) - factoryPositions.get(factoryIdx)) + 
                calculateMinDistance(robotIdx + 1, factoryIdx + 1, robot,factoryPositions);
        long skip = calculateMinDistance(robotIdx, factoryIdx + 1, robot, factoryPositions);
        long result = Math.min(assign, skip);
        dp[robotIdx][factoryIdx] = result;
        return result;
    }
}