class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-') cleaned.append(Character.toUpperCase(c));
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            if (count == k) {
                result.append('-');
                count = 0;
            }
            result.append(cleaned.charAt(i));
            count++;
        }
        return result.reverse().toString();
    }
}