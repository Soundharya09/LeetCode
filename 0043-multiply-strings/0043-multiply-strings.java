class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int dig1 = num1.charAt(i) - '0';
                int dig2 = num2.charAt(j) - '0';
                int prod = dig1 * dig2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = prod + res[pos2];
                res[pos2] = sum % 10;
                res[pos1] += sum / 10;
            }
        }
        for (int i = res.length - 1; i > 0; i--) {
            if (res[i] >= 10) {
                res[i - 1] += res[i] / 10;
                res[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(start < res.length - 1 && res[start] == 0) start++;
        for (int i = start; i < res.length; i++) sb.append(res[i]);
        return sb.toString();
    }
}