class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int n = s.length();
        if(s.equals(goal)) {
            Set<Character> ans = new HashSet<>();
            for(char ch : s.toCharArray()) {
                ans.add(ch);
            }
            return ans.size() < goal.length();
        }
        int i = 0, j = n-1;
        while(i < j && s.charAt(i) == goal.charAt(i)) i++;
        while(j >= 0 && s.charAt(j) == goal.charAt(j)) j--;
        if(i < j) {
            char[] arr = s.toCharArray();
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            s = new String(arr);
        }
        return s.equals(goal);
    }
}