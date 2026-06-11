class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int maxDepth = 0;
        int[] depth = new int[n + 1];
        Arrays.fill(depth, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        depth[1] = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            maxDepth = Math.max(maxDepth, depth[node]);
            for (int neighbor : adj.get(node)) {
                if (depth[neighbor] == -1) {
                    depth[neighbor] = depth[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        long MOD = 1_000_000_007L;
        if (maxDepth == 0) return 0; 
        
        long result = 1;
        for (int i = 0; i < maxDepth - 1; i++) {
            result = (result * 2) % MOD;
        }
        return (int) result;
    }
}