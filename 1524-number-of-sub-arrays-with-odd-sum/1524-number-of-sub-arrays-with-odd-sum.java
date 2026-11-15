class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long count = 0;
        int even = 1;
        int odd = 0;
        int prefix = 0; 

        for (int num : arr) {
            prefix = (prefix + num) & 1; 

            if (prefix == 1) {
                count += even; 
                odd++;
            } 
            else {
                count += odd;  
                even++;
            }
            count %= MOD;
        }
        return (int) count;
    }
}