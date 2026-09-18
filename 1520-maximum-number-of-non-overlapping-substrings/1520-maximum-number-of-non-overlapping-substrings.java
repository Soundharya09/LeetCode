class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int curEnd = last[c];
            boolean valid = true;
            int j = i;
            while (j <= curEnd) {
                int cc = s.charAt(j) - 'a';
                if (first[cc] < i) {
                    valid = false;
                    break;
                }
                curEnd = Math.max(curEnd, last[cc]);
                j++;
            }
            end[i] = valid ? curEnd : -1;
        }

        int[] dpCount = new int[n + 1];
        int[] dpLen = new int[n + 1];
        int[] choice = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int skipCount = dpCount[i + 1];
            int skipLen = dpLen[i + 1];

            if (end[i] != -1) {
                int nextIdx = end[i] + 1;
                int takeCount = 1 + dpCount[nextIdx];
                int takeLen = (end[i] - i + 1) + dpLen[nextIdx];

                if (takeCount > skipCount || (takeCount == skipCount && takeLen < skipLen)) {
                    dpCount[i] = takeCount;
                    dpLen[i] = takeLen;
                    choice[i] = 1;
                } 
                else {
                    dpCount[i] = skipCount;
                    dpLen[i] = skipLen;
                    choice[i] = 0;
                }
            } 
            else {
                dpCount[i] = skipCount;
                dpLen[i] = skipLen;
                choice[i] = 0;
            }
        }

        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (choice[i] == 1) {
                result.add(s.substring(i, end[i] + 1));
                i = end[i] + 1;
            }
            else i++;
        }
        return result;
    }
}