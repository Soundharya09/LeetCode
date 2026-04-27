class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];
        for(int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return gcd(min, max);
    }
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}