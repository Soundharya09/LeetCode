class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);

        int[] sortedVal = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            sortedVal[i] = nums[idx[i]];
            pos[idx[i]] = i;
        }

        int[] farthest = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < i) j = i;
            while (j + 1 < n && sortedVal[j + 1] - sortedVal[i] <= maxDiff) j++;
            farthest[i] = j;
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG += 1;

        int[][] up = new int[LOG][n];
        up[0] = farthest;
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0], v = queries[i][1];
            int p = pos[u], q = pos[v];
            if (p == q) {
                ans[i] = 0; 
                continue;
            }
            if (p > q) {
                int t = p; 
                p = q; 
                q = t;
            }
            int cur = p, hops = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < q) {
                    cur = up[k][cur];
                    hops += (1 << k);
                }
            }

            if (farthest[cur] >= q) ans[i] = hops + 1;
            else ans[i] = -1;
        }
        return ans;
    }
}