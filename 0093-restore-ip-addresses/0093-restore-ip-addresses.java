class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    public void backtrack(String s, int start, List<String> parts, List<String> result) {
        if (parts.size() == 4 && start == s.length()) {
            result.add(String.join(".", parts));
            return;
        }
        if (parts.size() == 4 || start == s.length()) return;
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;
            String segment = s.substring(start, start + len);
            if (segment.length() > 1 && segment.charAt(0) == '0') break;
            if (Integer.parseInt(segment) > 255) break;
            parts.add(segment);
            backtrack(s, start + len, parts, result);
            parts.remove(parts.size() - 1);
        }
    }
}