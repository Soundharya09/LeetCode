class Solution {
    public List<Integer> maxPrimeSubset(int n, int s) {
        List<Integer> res = new ArrayList<>();
        boolean[] composite = new boolean[n + 1];
        List<Integer> prime = new ArrayList<>();

        for(int i = 2; i <= n; i++) {
            if(!composite[i]) {
                prime.add(i);
                for(int j = i*i; j <= n; j += i) {
                    composite[j] = true;
                }
            }
        }
        int m = prime.size();
        final int INF = 1_000_000;
        int[][] f = new int[m + 1][s + 1];
        for(int[] row : f) {
            Arrays.fill(row, INF);
        }
        f[m][0] = 0;
        for(int i = m - 1; i >= 0; i--) {
            int p = prime.get(i);
            for(int j = 0; j <= s; j++) {
                f[i][j] = f[i + 1][j];
                if(j >= p && f[i + 1][j - p] + 1 < f[i][j]) {
                    f[i][j] = f[i + 1][j - p] + 1;
                }
            }
        }
        int best = 0;
        for(int j = s; j >= 1; j--) {
            if(f[0][j] < INF) {
                best = j;
                break;
            }
        }
        if(best == 0) return res;
        int count = f[0][best];
        int rem = best;
        int start = 0;
        while(count > 0) {
            for(int k = start; k < m; k++) {
                int p = prime.get(k);
                if(p <= rem && f[k + 1][rem - p] == count - 1) {
                    res.add(p);
                    rem -= p;
                    count--;
                    start = k + 1;
                    break;
                }
            }
        }
        return res;
    }
}