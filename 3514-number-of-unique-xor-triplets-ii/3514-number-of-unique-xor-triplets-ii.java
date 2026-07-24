class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int LIMIT = 2048;

        boolean[] pairXor = new boolean[LIMIT];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] tripleXor = new boolean[LIMIT];
        for (int v = 0; v < LIMIT; v++) {
            if (pairXor[v]) {
                for (int k = 0; k < n; k++) {
                    tripleXor[v ^ nums[k]] = true;
                }
            }
        }

        int count = 0;
        for (int v = 0; v < LIMIT; v++) {
            if (tripleXor[v]) count++;
        }

        return count;
    }
}