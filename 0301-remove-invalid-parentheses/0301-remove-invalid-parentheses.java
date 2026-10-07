class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        Set<String> result = new HashSet<>();
        backtrack(s, 0, 0, 0, left, right, new StringBuilder(), result);
        return new ArrayList<>(result);
    }
    private void backtrack(String s, int index, int open, int close, int remL, int remR, StringBuilder sb, Set<String> result) {
        if (index == s.length()) {
            if (remL == 0 && remR == 0) {
                result.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = sb.length();

        if (c == '(' && remL > 0) {
            backtrack(s, index + 1, open, close, remL - 1, remR, sb, result);
        } else if (c == ')' && remR > 0) {
            backtrack(s, index + 1, open, close, remL, remR - 1, sb, result);
        }

        sb.append(c);
        if (c != '(' && c != ')') {
            backtrack(s, index + 1, open, close, remL, remR, sb, result);
        } else if (c == '(') {
            backtrack(s, index + 1, open + 1, close, remL, remR, sb, result);
        } else if (open > close) {
            backtrack(s, index + 1, open, close + 1, remL, remR, sb, result);
        }
        sb.setLength(len);
    }
}