class Solution {
    public boolean hasEvenSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 2 == 0; 
    }
    public int countEven(int num) {
        int count = 0;
        for(int i = 1; i <= num; i++) {
            if(hasEvenSum(i)) count++;
        }
        return count;
    }
}