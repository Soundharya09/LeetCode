class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degree = new int[n + 1];
        Set<Long> edgeSet = new HashSet<>();
        for (List<Integer> edge : edges) {
            int a = edge.get(0), b = edge.get(1);
            degree[a]++;
            degree[b]++;
            edgeSet.add(encode(a, b));
        }
        List<Integer> odd = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 != 0) odd.add(i);
        }
        int size = odd.size();
        if (size == 0) return true;
        if (size == 2) {
            int u = odd.get(0), v = odd.get(1);
            if (!edgeSet.contains(encode(u, v))) return true;
            for (int w = 1; w <= n; w++) {
                if (w != u && w != v && !edgeSet.contains(encode(u, w)) && !edgeSet.contains(encode(v, w))) {
                    return true;
                }
            }
            return false;
        }
        if (size == 4) {
            int a = odd.get(0), b = odd.get(1), c = odd.get(2), d = odd.get(3);
            return (canPair(a, b, c, d, edgeSet)) ||
                   (canPair(a, c, b, d, edgeSet)) ||
                   (canPair(a, d, b, c, edgeSet));
        }
        return false;
    }
    public boolean canPair(int a, int b, int c, int d, Set<Long> edgeSet) {
        return !edgeSet.contains(encode(a, b)) && !edgeSet.contains(encode(c, d));
    }
    public long encode(int a, int b) {
        if (a > b) { int t = a; a = b; b = t; }
        return (long) a * 100001 + b;
    }
}