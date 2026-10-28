class Solution {
    public int minFlips(int a, int b, int c) {
        int ab = a | b;
        int diff = ab ^ c;                        
        int bothSetWhereCZero = a & b & ~c;       
        return Integer.bitCount(diff) + Integer.bitCount(bothSetWhereCZero);
    }
}