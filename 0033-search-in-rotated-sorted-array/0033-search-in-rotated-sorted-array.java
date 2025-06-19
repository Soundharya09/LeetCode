class Solution {
    public int search(int[] arr, int target) {
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == target) {
        //         return i;
        //     }
        // }
        // return -1;
        int n = arr.length;
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < arr[high]) { // At right sorted array
                if(target > arr[mid] && target <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
            else { // At left sorted array
                if(target >= arr[low] && target <= arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }
}