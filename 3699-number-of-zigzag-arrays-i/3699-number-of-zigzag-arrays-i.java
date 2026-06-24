class Solution {
    static final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[] up = new long[m];
        long[] down = new long[m];
        Arrays.fill(up, 1L);
        Arrays.fill(down, 1L);

        for (int step = 1; step < n; step++) {
            long[] newUp = new long[m];
            long[] newDown = new long[m];
            long[] prefixUp = new long[m + 1];
            for (int i = 0; i < m; i++) {
                prefixUp[i + 1] = (prefixUp[i] + up[i]) % MOD;
            }
            long[] suffixDown = new long[m + 1];
            for (int i = m - 1; i >= 0; i--) {
                suffixDown[i] = (suffixDown[i + 1] + down[i]) % MOD;
            }
            for (int y = 0; y < m; y++) {
                newDown[y] = prefixUp[y];        
                newUp[y] = suffixDown[y + 1];    
            }
            up = newUp;
            down = newDown;
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }
        return (int) ans;
    }
}