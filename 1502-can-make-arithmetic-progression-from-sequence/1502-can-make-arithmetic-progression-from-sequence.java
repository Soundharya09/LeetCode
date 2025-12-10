class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int ans = arr[1] - arr[0];
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i-1] != ans) return false;
        }
        return true;
    }
}