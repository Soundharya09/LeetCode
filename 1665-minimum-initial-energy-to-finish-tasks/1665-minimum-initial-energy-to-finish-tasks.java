class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int reqEnergy = 0;
        for(int i = tasks.length - 1; i >= 0; i--) {
            int actual = tasks[i][0];
            int min = tasks[i][1];
            reqEnergy = Math.max(reqEnergy + actual, min);
        }
        return reqEnergy;
    }
}