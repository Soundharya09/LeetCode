class Solution {
    public int magicalString(int n) {
        if(n <= 0) return 0;
        if(n <= 3) return 1;
        int[] s = new int[n + 1];
        s[0] = 1; s[1] = 2; s[2] = 2;
        int head = 2, tail = 3, next = 1, ones = 1;
        while (tail < n) {
            int count = s[head];
            for (int i = 0; i < count && tail < n; i++) {
                s[tail] = next;
                if (next == 1) ones++;
                tail++;
            }
            next = 3 - next;
            head++;
        }
        return ones;
    }
}