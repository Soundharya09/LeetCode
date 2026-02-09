class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] inStack = new boolean[26];
        StringBuilder stack = new StringBuilder();
        for(char c : s.toCharArray()) {
            int idx = c - 'a';
            count[idx]--;
            if(inStack[idx]) continue;
            while(stack.length() > 0 && stack.charAt(stack.length() - 1) > c && count[stack.charAt(stack.length() - 1) - 'a'] > 0) {
                char remove = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                inStack[remove - 'a'] = false;
            }
            stack.append(c);
            inStack[idx] = true;
        }
        return stack.toString();
    }
}