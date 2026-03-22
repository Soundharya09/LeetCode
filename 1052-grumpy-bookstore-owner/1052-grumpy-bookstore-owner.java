class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int baseSum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) baseSum += customers[i];
        }
        int windowSum = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) windowSum += customers[i];
        }
        int maxExtra = windowSum;
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) windowSum += customers[i];
            if (grumpy[i - minutes] == 1) windowSum -= customers[i - minutes];
            maxExtra = Math.max(maxExtra, windowSum);
        }
        return baseSum + maxExtra;
    }
}