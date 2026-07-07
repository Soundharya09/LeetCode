class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(char c : s.toCharArray()) {
            if(c != '0') {
                sb.append(c);
                sum += (c - '0');
            }
        }
        long x = 0;
        if(sb.length() == 0) x = 0;
        else x = Long.parseLong(sb.toString());
        return x * sum;
    }
}