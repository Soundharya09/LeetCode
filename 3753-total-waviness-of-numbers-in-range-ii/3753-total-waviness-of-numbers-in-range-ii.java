class Solution {
    private int[] digits;
    private long[][][][] memoSum;
    private long[][][][] memoCnt;
    private boolean[][][][] memoVisited;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
    public long solve(long num) {
        if (num <= 0) return 0;
        String s = Long.toString(num);
        int n = s.length();
        digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = s.charAt(i) - '0';

        memoSum = new long[n][2][12][12];
        memoCnt = new long[n][2][12][12];
        memoVisited = new boolean[n][2][12][12];

        long[] res = dfs(0, 1, -1, -1);
        return res[0];
    }
    public long[] dfs(int pos, int tight, int last, int secondLast) {
        int n = digits.length;
        if (pos == n) return new long[]{0, 1};
        
        int tIdx = tight;
        int lIdx = last + 1;  
        int slIdx = secondLast + 1;

        if (memoVisited[pos][tIdx][lIdx][slIdx]) {
            return new long[]{memoSum[pos][tIdx][lIdx][slIdx], memoCnt[pos][tIdx][lIdx][slIdx]};
        }

        int limit = tight == 1 ? digits[pos] : 9;
        long totalWav = 0, totalCnt = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            if (last == -1 && d == 0) {
                long[] sub = dfs(pos + 1, newTight, -1, -1);
                totalWav += sub[0];
                totalCnt += sub[1];
            } 
            else {
                long waveContrib = 0;
                if (last != -1 && secondLast != -1) {
                    if (last > secondLast && last > d) waveContrib = 1;      
                    else if (last < secondLast && last < d) waveContrib = 1; 
                }

                long[] sub = dfs(pos + 1, newTight, d, last == -1 ? -1 : last);
                totalWav += sub[0] + waveContrib * sub[1];
                totalCnt += sub[1];
            }
        }

        memoVisited[pos][tIdx][lIdx][slIdx] = true;
        memoSum[pos][tIdx][lIdx][slIdx] = totalWav;
        memoCnt[pos][tIdx][lIdx][slIdx] = totalCnt;
        return new long[]{totalWav, totalCnt};
    }
}