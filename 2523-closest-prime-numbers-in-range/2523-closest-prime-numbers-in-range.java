class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        if (right >= 0) isPrime[0] = false;
        if (right >= 1) isPrime[1] = false;
        
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) isPrime[j] = false;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime[i]) primes.add(i);
        }
        if (primes.size() < 2) return new int[]{-1, -1};
        int minDiff = Integer.MAX_VALUE;
        int bestNum1 = -1;
        int bestNum2 = -1;
        
        for (int i = 0; i < primes.size() - 1; i++) {
            int p1 = primes.get(i);
            int p2 = primes.get(i + 1);
            int diff = p2 - p1;
            
            if (diff < minDiff) {
                minDiff = diff;
                bestNum1 = p1;
                bestNum2 = p2;
            }
            if (minDiff == 2) break;
        }
        return new int[]{bestNum1, bestNum2};
    }
}