class Solution {
    public int nextBeautifulNumber(int n) {
         for (int x = n + 1; ; x++) {
            if (isBalanced(x)) return x;
        }
    }
    
    public boolean isBalanced(int x) {
        int[] count = new int[10];
        int tmp = x;
        while (tmp > 0) {
            count[tmp % 10]++;
            tmp /= 10;
        }
        tmp = x;
        while (tmp > 0) {
            int d = tmp % 10;
            if (count[d] != d) return false;
            tmp /= 10;
        }
        return true;
    }
}