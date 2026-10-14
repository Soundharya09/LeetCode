class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> res = new ArrayList<>();
        if(n < 2) return res;

        boolean[] composite = new boolean[n + 1];
        long sum = 0;

        for(int i = 2; i <= n; i++) {
            if(!composite[i]) {
                if(sum + i > s) break;
                sum += i;
                res.add(i);
                for(long j = (long) i*i; j <= n; j += i) {
                    composite[(int) j] = true;
                }
            }
        }
        return res;
    }
}