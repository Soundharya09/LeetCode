class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }
            int numWords = j - i;
            int numGaps = numWords - 1;
            int totalChars = 0;
            for (int k = i; k < j; k++) {
                totalChars += words[k].length();
            }
            int totalSpaces = maxWidth - totalChars;
            StringBuilder sb = new StringBuilder();
            if (j == words.length || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } 
            else {
                int spacePerGap = totalSpaces / numGaps;
                int extraSpaces = totalSpaces % numGaps;
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spaces = spacePerGap + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spaces; s++) sb.append(' ');
                    }
                }
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }
}