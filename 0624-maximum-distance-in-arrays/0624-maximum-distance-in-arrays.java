class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int Gmin = arrays.get(0).get(0);
        int Gmax = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for(int i = 1; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int Lmin = curr.get(0);
            int Lmax = curr.get(curr.size() - 1);

            ans = Math.max(ans, Math.max(Lmax - Gmin, Gmax - Lmin));

            Gmin = Math.min(Gmin, Lmin);
            Gmax = Math.max(Gmax, Lmax);
        }
        return ans;
    }
}