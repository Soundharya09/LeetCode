class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        boolean flag = false;
        for(char ch : letters) {
            if(!flag) {
                if(ch > target) {
                    ans = ch;
                    flag = !flag;
                }
            }
            else {
                if(ch > target && ch < ans) ans = ch;
            }
        }
        return ans;
    }
}