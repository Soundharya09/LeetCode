class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        List<Integer> onesPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') onesPos.add(i);
        }
        int total = onesPos.size();
        String best = "";
        for (int i = 0; i + k - 1 < total; i++) {
            int start = onesPos.get(i);           
            int end = onesPos.get(i + k - 1);     
            String candidate = s.substring(start, end + 1);
            if (best.isEmpty()
                || candidate.length() < best.length()
                || (candidate.length() == best.length() && candidate.compareTo(best) < 0)) {
                best = candidate;
            }
        }
        return best;
    }
}