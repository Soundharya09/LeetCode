class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(isSelfDividing(i)) res.add(i);
        }
        return res;
    }
    public boolean isSelfDividing(int i) {
        int n = i;
        while(n > 0) {
            int d = n % 10;
            if(d == 0 || i % d != 0) return false;
            n /= 10;
        }
        return true;
    }
}