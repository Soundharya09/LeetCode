class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int rev_num = 0, temp = x;
        while(temp != 0) {
            int digit = temp % 10;
            rev_num = rev_num * 10 + digit;
            temp /= 10;
        }
        return rev_num == x;
    }
}