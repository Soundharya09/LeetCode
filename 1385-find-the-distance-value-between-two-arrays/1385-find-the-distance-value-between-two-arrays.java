class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for(int a : arr1) {
            if(isFarFromAll(arr2, a, d)) count++;
        }
        return count;
    }

    private boolean isFarFromAll(int[] arr2, int a, int d) {
        int low = 0, high = arr2.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int diff = Math.abs(arr2[mid] - a);

            if(diff <= d) return false;
            else if(arr2[mid] < a) low = mid + 1;
            else high = mid - 1;
        }
        return true;
    }
}