class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        int m = queries.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> queries[a] - queries[b]);
        int[] freq = new int[n + 1];
        int active = 0;         
        int left = 0, right = 0; 
        int[] ans = new int[m];

        for (int k = 0; k < m; k++) {
            int q = queries[idx[k]];
            int lo = q - x;

            while (right < logs.length && logs[right][1] <= q) {
                if (freq[logs[right][0]]++ == 0) active++;
                right++;
            }
            while (left < right && logs[left][1] < lo) {
                if (--freq[logs[left][0]] == 0) active--;
                left++;
            }
            ans[idx[k]] = n - active;
        }
        return ans;
    }
}