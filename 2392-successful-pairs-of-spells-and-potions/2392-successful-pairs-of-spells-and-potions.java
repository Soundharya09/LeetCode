class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length; int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i];
            int left = 0, right = m - 1, pos = m; 
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= minPotion) {
                    pos = mid; 
                    right = mid - 1;
                } 
                else left = mid + 1;
            }
            ans[i] = m - pos;
        }
        return ans;
    }
}