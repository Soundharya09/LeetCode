class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            int count = 0;
            int temp = i;
            while(temp != 0) {
                int ans = temp & 1;
                if(ans == 1) count++;
                temp >>= 1;
            }
            arr[i] = count;
        }
        return arr;
    }
}