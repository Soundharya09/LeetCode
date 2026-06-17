class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n + 1];
        lengths[0] = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') lengths[i + 1] = Math.max(0, lengths[i] - 1);
            else if (c == '#') {
                lengths[i + 1] = Math.min(2_000_000_000_000_000L, lengths[i] * 2);
            }
            else if (c == '%') lengths[i + 1] = lengths[i];
            else lengths[i + 1] = lengths[i] + 1;
        }
        if (k >= lengths[n]) return '.';
        long pos = k;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long lenBefore = lengths[i];   
            long lenAfter  = lengths[i + 1];
            if (c == '#') {
                if (pos >= lenBefore) pos -= lenBefore;
            } 
            else if (c == '%') pos = lenAfter - 1 - pos;
            else if (c != '*') {
                if (pos == lenBefore) return c;
            }
        }
        return '.';
    }
}