class Solution {
     public int getSquaresSum(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        slow = getSquaresSum(slow);
        fast = getSquaresSum(getSquaresSum(fast));
        
        if(fast == 1) return true;
        while(slow != fast) {
            slow = getSquaresSum(slow);
            fast = getSquaresSum(getSquaresSum(fast));
            if (slow == 1 || fast == 1) return true;
        }
        return false;
    }
}