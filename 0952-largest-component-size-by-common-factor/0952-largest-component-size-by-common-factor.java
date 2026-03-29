class Solution {
    private int[] parent, rank;
    public int largestComponentSize(int[] nums) {
        int maxVal = 0;
        for(int n : nums) maxVal = Math.max(maxVal, n);
        parent = new int[maxVal + 1];
        rank = new int[maxVal + 1];
        for(int i = 0; i <= maxVal; i++) {
            parent[i] = i;
        }
        for(int n : nums) {
            for(int f = 2; (long) f * f <= n; f++) {
                if(n % f == 0) {
                    union(n, f);
                    union(n, n / f);
                }
            }
        }
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int n : nums) {
            int root = find(n);
            count.merge(root, 1, Integer::sum);
            ans = Math.max(ans, count.get(root));
        }
        return ans;
    }
    public void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;
        if (rank[ra] < rank[rb]) parent[ra] = rb;
        else if (rank[ra] > rank[rb]) parent[rb] = ra;
        else { 
            parent[rb] = ra; 
            rank[ra]++; 
        }
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}