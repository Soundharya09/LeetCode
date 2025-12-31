class Solution {
    public String clearDigits(String s) {
        Stack<Character> ans = new Stack<>();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                if(!ans.isEmpty()) ans.pop();
            }
            else ans.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : ans) sb.append(ch);
        return sb.toString();
    }
}