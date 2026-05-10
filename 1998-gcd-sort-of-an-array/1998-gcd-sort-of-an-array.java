class Solution {
    private int[] parent;
    public boolean gcdSort(int[] nums) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);
        parent = new int[max + 1];
        for (int i = 0; i <= max; i++) parent[i] = i;
        
        int[] spf = smallestPrimeFactor(max);
        
        for (int x : nums) {
            int tmp = x;
            while (tmp > 1) {
                int p = spf[tmp];
                union(x, p);
                while (tmp % p == 0) tmp /= p;
            }
        }
        
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        for (int i = 0; i < nums.length; i++) {
            if (find(nums[i]) != find(sorted[i])) return false;
        }
        return true;
    }
    
    public int[] smallestPrimeFactor(int max) {
        int[] spf = new int[max + 1];
        for (int i = 0; i <= max; i++) spf[i] = i;
        for (int i = 2; i * i <= max; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= max; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
        return spf;
    }
    
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}