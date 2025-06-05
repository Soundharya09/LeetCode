class Solution {
    public int compress(char[] chars) {
        int idx = 0, i = 0;
        while (i < chars.length) {
            char current = chars[i];
            int j = i;
            while (j < chars.length && chars[j] == current) j++;
            chars[idx++] = current;
            int count = j - i;
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[idx++] = c;
                }
            }
            i = j;
        }
        return idx;
    }
}
