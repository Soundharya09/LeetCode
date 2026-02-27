class Solution {
    public int largestAltitude(int[] gain) {
        // Approach - 1 Brute Force 
        int max = 0, current = 0;
        for(int g : gain) {
            current += g;
            max = Math.max(max, current);
        }
        return max;

        // Approach - 2 Prefix Sum
        // int[] prefix = new int[gain.length + 1];
        // for(int i = 1; i <= gain.length; i++) {
        //     prefix[i] = prefix[i - 1] + gain[i - 1];
        // }
        // int max = 0;
        // for(int val : prefix) {
        //     max = Math.max(max, val);
        // }
        // return max;
    }
}