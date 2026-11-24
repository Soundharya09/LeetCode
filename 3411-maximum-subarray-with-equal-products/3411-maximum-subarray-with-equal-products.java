class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        final long LIMIT = 2520L * 10;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long g = 0;
            long l = 1;
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                if (prod > LIMIT) break;
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);
                if (prod == l * g) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}