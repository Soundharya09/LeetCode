class Solution {
    public boolean isAnagram(String s, String t) {
        // if(s.length() != t.length()) return false;
        // else {
        //     char[] a = s.toCharArray();
        //     char[] b = t.toCharArray();
        //     Arrays.sort(a);
        //     Arrays.sort(b);
        //     for(int i=0; i<a.length; i++) {
        //         if(a[i] != b[i]) return false;
        //     }
        // }
        // return true;
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}