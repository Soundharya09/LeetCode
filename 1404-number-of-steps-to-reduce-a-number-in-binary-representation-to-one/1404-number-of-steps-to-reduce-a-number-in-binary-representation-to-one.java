class Solution {
    public int numSteps(String s) {
        int carry = 0, steps = 0;
        for(int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;
            if(bit == 1) {
                steps += 2;
                carry = 1;
            }
            else steps += 1;
        }
        return steps + carry;
    }
}