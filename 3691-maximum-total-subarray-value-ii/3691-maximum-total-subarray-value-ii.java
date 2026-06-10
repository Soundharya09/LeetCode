class Solution {
    private int[][] sparseMax;
    private int[][] sparseMin;
    private int[] log2;
    private int n;

    public long maxTotalValue(int[] nums, int k) {
        n = nums.length;
        buildSparseTable(nums);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        for (int l = 0; l < n; l++) {
            pq.offer(new long[]{query(l, n - 1), l, n - 1});
        }

        long total = 0;
        for (int i = 0; i < k; i++) {
            long[] top = pq.poll();
            int l = (int) top[1];
            int r = (int) top[2];
            total += top[0];
            if (r > l) {
                pq.offer(new long[]{query(l, r - 1), l, r - 1});
            }
        }
        return total;
    }

    public void buildSparseTable(int[] nums) {
        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        sparseMax = new int[LOG][n];
        sparseMin = new int[LOG][n];
        log2 = new int[n + 1];
        log2[1] = 0;
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }
        for (int i = 0; i < n; i++) {
            sparseMax[0][i] = nums[i];
            sparseMin[0][i] = nums[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                sparseMax[j][i] = Math.max(sparseMax[j-1][i], sparseMax[j-1][i + (1 << (j-1))]);
                sparseMin[j][i] = Math.min(sparseMin[j-1][i], sparseMin[j-1][i + (1 << (j-1))]);
            }
        }
    }

    public long query(int l, int r) {
        int k = log2[r - l + 1];
        int maxVal = Math.max(sparseMax[k][l], sparseMax[k][r - (1 << k) + 1]);
        int minVal = Math.min(sparseMin[k][l], sparseMin[k][r - (1 << k) + 1]);
        return maxVal - minVal;
    }
}
