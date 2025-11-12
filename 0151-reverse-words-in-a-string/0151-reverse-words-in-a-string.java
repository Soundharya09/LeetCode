class Solution {
    public void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int i = 0, j = 0;
        boolean space = false;
        while(j < n) {
            if(arr[j] == ' ') {
                if(!space & i > 0) {
                    arr[i++] = ' ';
                    space = true;
                }
                j++;
            }
            else {
                arr[i++] = arr[j++];
                space = false;
            }
        }
        int len = i > 0 && arr[i - 1] == ' ' ? i - 1 : i;
        reverse(arr, 0, len-1);
        int start = 0;
        for (int p = 0; p <= len; p++) {
            if (p == len || arr[p] == ' ') {
                reverse(arr, start, p - 1);
                start = p + 1;
            }
        }
        return new String(arr, 0, len);
    }
}