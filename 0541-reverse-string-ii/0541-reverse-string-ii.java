class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i = 0; i < n; i += 2*k){
            int left = i, right = i + k - 1;
            if (right >= n) right = n - 1;
            while(left < right){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++; right--;
            }
        }
        return String.valueOf(arr);
    }
}