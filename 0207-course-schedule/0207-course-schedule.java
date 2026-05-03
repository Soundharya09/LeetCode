class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(i, adj, state)) return false;
        }
        return true;
    }
    public boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
        state[node] = 1; 
        for (int neighbor : adj.get(node)) {
            if (state[neighbor] == 1) return true;  
            if (state[neighbor] == 0 && hasCycle(neighbor, adj, state)) return true;
        }
        state[node] = 2; 
        return false;
    }
}