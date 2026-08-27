class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for(int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        char[] res = new char[n];
        if(solve(0, count, target, res, n)) return new String(res);
        return "";
    }

    private boolean solve(int i, int[] count, String target, char[] result, int n){
        if (i == n) return false;
        int c = target.charAt(i) - 'a';
        if (count[c] > 0) {
            count[c]--;
            result[i] = (char) ('a' + c);
            if (solve(i + 1, count, target, result, n)) return true;
            count[c]++; 
        }
        for (int j = c + 1; j < 26; j++) {
            if (count[j] > 0) {
                count[j]--;
                result[i] = (char) ('a' + j);
                int idx = i + 1;
                for (int k = 0; k < 26; k++) {
                    while (count[k] > 0) {
                        result[idx++] = (char) ('a' + k);
                        count[k]--;
                    }
                }
                return true;
            }
        }
        return false;
    }
}