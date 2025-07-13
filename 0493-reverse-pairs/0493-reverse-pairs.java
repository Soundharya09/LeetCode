class Solution {
    static int count; //global variable
    public void inversion(int[] a, int[] b) {
        int i = 0, j = 0;
        while(i < a.length && j < b.length) {
            if((long)a[i] > (long)2 * (long)b[j]) { //typecasting int -> long
                count += (a.length - i);
                j++;
            }
            else i++;
        }
    }
    public void merge(int[] a, int[] b, int[] ans) {
        //RECURSIVE APPROACH
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] <= b[j]) ans[k++] = a[i++];
            else ans[k++] = b[j++];
        }
        while(j < b.length) ans[k++] = b[j++];
        while(i < a.length) ans[k++] = a[i++];
    }
    public void mergesort(int[] arr) {
        int n = arr.length;
        if(n == 1) return; //base case
        //Create 2 arrays of size n/2 each
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];
        //Copy the arrays
        for(int i = 0; i < n/2; i++) a[i] = arr[i];
        for(int i = 0; i < n-n/2; i++) b[i] = arr[i + n/2];
        //Magic using Recursion
        mergesort(a);
        mergesort(b);
        inversion(a,b);
        //Merge these 'a' & 'b'
        merge(a,b,arr);
        //Delete a & b
        a = null; b = null;
    }
    public int reversePairs(int[] arr) {
        count = 0; 
        mergesort(arr);
        return count;
    }
}