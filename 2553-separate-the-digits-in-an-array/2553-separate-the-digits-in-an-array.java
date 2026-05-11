class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int x : nums) {
            List<Integer> temp = new ArrayList<>();
            while(x > 0) {
                temp.add(x % 10);
                x /= 10;
            }
            for(int i = temp.size() - 1; i >= 0; i--) {
                res.add(temp.get(i));
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}