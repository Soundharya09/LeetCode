class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int oddCount = 0;
        char middleChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                middleChar = (char) ('a' + i);
            }
        }
        if ((n % 2 == 0 && oddCount > 0) || (n % 2 == 1 && oddCount != 1)) {
            return "";
        }
        int halfLen = n / 2;
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }
        char[] result = new char[n];
        if (buildPalindrome(halfFreq, middleChar, n, halfLen, target, 0, result, false)) {
            return new String(result);
        }
        return "";
    }

    private boolean buildPalindrome(int[] halfFreq, char middleChar, int n, int halfLen, String target, int pos, char[] result, boolean alreadyGreater) {
        if (pos == halfLen) {
            if (n % 2 == 1) result[halfLen] = middleChar;
            fillSecondHalf(result, halfLen, n);
            String candidate = new String(result);
            return candidate.compareTo(target) > 0;
        }
        for (int c = 0; c < 26; c++) {
            if (halfFreq[c] == 0) continue;
            char ch = (char) ('a' + c);
            result[pos] = ch;
            boolean newAlreadyGreater = alreadyGreater;
            if (!alreadyGreater) {
                if (ch > target.charAt(pos)) newAlreadyGreater = true;
                else if (ch < target.charAt(pos)) continue;
            }
            halfFreq[c]--;
            if (buildPalindrome(halfFreq, middleChar, n, halfLen, target, pos + 1, result, newAlreadyGreater)) {
                return true;
            }
            halfFreq[c]++;
        }
        return false;
    }
    
    private void fillSecondHalf(char[] result, int halfLen, int n) {
        for (int i = 0; i < halfLen; i++) {
            result[n - 1 - i] = result[i];
        }
    }
}