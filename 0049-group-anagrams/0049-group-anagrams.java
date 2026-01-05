class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            int[] count = new int[26];
            for(char c : ch) count[c - 'a']++;
            String key = Arrays.toString(count);
            ans.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}