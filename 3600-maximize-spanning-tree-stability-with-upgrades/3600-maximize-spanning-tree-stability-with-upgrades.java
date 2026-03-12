class Solution {
    int[] parent, rnk;
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (rnk[px] < rnk[py]) { 
            int t = px; 
            px = py; 
            py = t; 
        }
        parent[py] = px;
        if (rnk[px] == rnk[py]) rnk[px]++;
        return true;
    }
    boolean canAchieve(int mid, int n, int[][] edges, int k) {
        parent = new int[n];
        rnk = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int used = 0;
        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < mid) return false;
                if (union(e[0], e[1])) used++;
            }
        }
        for (int[] e : edges) {
            if (e[3] == 0 && e[2] >= mid) {
                if (union(e[0], e[1])) used++;
            }
        }
        int rem = k;
        for (int[] e : edges) {
            if (e[3] == 0 && e[2] < mid && e[2] * 2 >= mid && rem > 0) {
                if (union(e[0], e[1])) {
                    used++;
                    rem--;
                }
            }
        }
        return used == n - 1;
    }
    public int maxStability(int n, int[][] edges, int k) {
        parent = new int[n];
        rnk = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] e : edges) {
            if (e[3] == 1 && !union(e[0], e[1])) return -1;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] e : edges) {
            set.add(e[2]);
            set.add(e[2] * 2);
        }
        List<Integer> candidates = new ArrayList<>(set);
        int lo = 0, hi = candidates.size() - 1, ans = -1;
        while (lo <= hi) {
            int m = (lo + hi) / 2;
            if (canAchieve(candidates.get(m), n, edges, k)) {
                ans = candidates.get(m);
                lo = m + 1;
            }
            else hi = m - 1;
        }
        return ans;
    }
}