class Solution {
    public int[] divideAndConquer(int n) {
        if(n == 1) return new int[]{1};

        int leftSize = (n + 1) / 2;
        int rightSize = n / 2;

        int[] left  = divideAndConquer(leftSize);   
        int[] right = divideAndConquer(rightSize);

        int[] res = new int[n];
        int idx = 0;

        for(int x : left) res[idx++] = 2 * x - 1;
        for(int x : right) res[idx++] = 2 * x;
        
        return res;
    }
    public int[] beautifulArray(int n) {
        return divideAndConquer(n);
    }
}