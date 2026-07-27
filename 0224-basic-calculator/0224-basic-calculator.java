class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0, sign = 1, n = s.length(), i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * num;
                continue; 
            } 
            else if (c == '+') sign = 1;
            else if (c == '-') sign = -1;
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } 
            else if (c == ')') {
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
            }
            i++;
        }
        return result;
    }
}