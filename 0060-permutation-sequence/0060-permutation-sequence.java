class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<>();
        for(int i = 1; i <= n; i++) digits.add(i);

        int[] fact = new int[n+1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++) fact[i] = fact[i-1] * i;
        k = k - 1;

        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i >= 0; i--) {
            int factorial = fact[i];
            int idx = k / factorial;
            k = k % factorial;
            sb.append(digits.get(idx));
            digits.remove(idx);
        }
        return sb.toString();
    }
}