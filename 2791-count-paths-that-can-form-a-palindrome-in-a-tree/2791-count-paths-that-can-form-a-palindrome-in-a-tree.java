class Solution {
    private Map<Integer, Integer> maskCount = new HashMap<>();
    private long result = 0;
    private List<List<int[]>> adj;

    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            int p = parent.get(i);
            int bit = s.charAt(i) - 'a';
            adj.get(p).add(new int[]{i, bit});
        }

        maskCount.put(0, 1);
        dfs(0, 0);
        return result;
    }
    public void dfs(int node, int mask) {
        for (int[] next : adj.get(node)) {
            int newMask = mask ^ (1 << next[1]);

            result += maskCount.getOrDefault(newMask, 0);
            for (int i = 0; i < 26; i++) {
                result += maskCount.getOrDefault(newMask ^ (1 << i), 0);
            }
            maskCount.merge(newMask, 1, Integer::sum);
            dfs(next[0], newMask);
        }
    }
}