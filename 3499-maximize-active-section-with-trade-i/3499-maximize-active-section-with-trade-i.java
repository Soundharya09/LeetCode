class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";
        int n = t.length();
        List<Character> ch = new ArrayList<>();
        List<Integer> len = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && t.charAt(j) == t.charAt(i)) j++;
            ch.add(t.charAt(i));
            len.add(j - i);
            i = j;
        }
        int originalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') originalOnes++;
        }
        int maxDelta = 0;
        int m = ch.size();
        for (int k = 1; k < m - 1; k++) {
            if (ch.get(k) == '1' && ch.get(k - 1) == '0' && ch.get(k + 1) == '0') {
                int delta = len.get(k - 1) + len.get(k + 1);
                maxDelta = Math.max(maxDelta, delta);
            }
        }
        return originalOnes + maxDelta;
    }
}