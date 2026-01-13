class Solution {
    public double separateSquares(int[][] squares) {
        long total = 0;
        double maxY = 0;
        for(int[] s : squares) {
            total += (long) s[2] * s[2];
            maxY = Math.max(maxY, s[1] + s[2]);
        }
        double l = 0, r = maxY + 1;
        for (int i = 0; i < 90; i++) {
            double m = l + (r - l) / 2;
            double below = 0;
            for (int[] s : squares) {
                double b = s[1], t = s[1] + s[2];
                if (m <= b) continue;
                if (m >= t) below += (double)s[2] * s[2];
                else below += (m - b) * s[2];
            }
            if(below * 2 >= total) r = m;
            else l = m;
        }
        return l;
    }
}