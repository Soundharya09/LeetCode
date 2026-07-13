class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String numbers = "123456789";
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for(int len = lowLen; len <= highLen; len++) {
            for(int start = 0; start + len <= numbers.length(); start++) {
                String sub = numbers.substring(start, start + len);
                int num = Integer.parseInt(sub);
                if(num >= low && num <= high) ans.add(num);
            }
        }
        return ans;
    }
}