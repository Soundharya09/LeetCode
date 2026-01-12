class Solution {
    public int dfs(List<Integer> masks, int pos, int used) {
        int ans = Integer.bitCount(used);
        for (int i = pos; i < masks.size(); i++) {
            if ((used & masks.get(i)) == 0) {
                ans = Math.max(ans, dfs(masks, i + 1, used | masks.get(i)));
            }
        }
        return ans;
    }
    public int maxLength(List<String> arr) {
        List<Integer> validMasks = new ArrayList<>();
        for(String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                int bit = 1 << (c - 'a');
                if ((mask & bit) != 0) {
                    mask = -1;  
                    break;
                }
                mask |= bit;
            }
            if (mask != -1) validMasks.add(mask);
        }  
        return dfs(validMasks, 0, 0);
    }
}