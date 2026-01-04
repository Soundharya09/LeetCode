class Solution {
    public int getSumOfFourDivisors(int n) {
        if(n <= 3) return 0;
        int count = 0, sum = 0;
        for(int i = 1; i*i <= n; i++) {
            if(n % i == 0) {
                sum += i;
                count++;
                if(i != n/i) {
                    sum += n/i;
                    count++;
                }
                if(count > 4) return 0;
            }
        }
        if(count == 4) return sum;
        else return 0;
    }
    public int sumFourDivisors(int[] nums) {
       int totalSum = 0;
       for(int num : nums) {
           int divisorSum = getSumOfFourDivisors(num);
           totalSum += divisorSum;
        }
        return totalSum;
    }
}