class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> hasIncoming = new HashSet<>();
        for(List<Integer> edge : edges) {
            hasIncoming.add(edge.get(1));
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!hasIncoming.contains(i)) res.add(i);
        }
        return res;
    }
}