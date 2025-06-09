class Solution {
    public String reverseVowels(String s) {
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0, j = n-1;
        while(i < j){
            int ivowel = 0;
            while(ivowel < vowels.length && arr[i] != vowels[ivowel]) {
                ivowel++;
            }
            int jvowel = 0;
            while(jvowel < vowels.length && arr[j] != vowels[jvowel]) {
                jvowel++;
            }
            if(ivowel < vowels.length && jvowel < vowels.length) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
            else {
                if(ivowel == vowels.length) i++;
                if(jvowel == vowels.length) j--;
            }
        }
        return new String(arr);
    }
}