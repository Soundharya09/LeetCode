class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] a) {
        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        dfs(0, curr, ans, a, n-1);
        return ans;
    }
    public void dfs(int x, ArrayList<Integer> curr, List<List<Integer>> ans, int[][] a, int des) {
        curr.add(x);
        if(x == des) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < a[x].length; i++) {
            dfs(a[x][i], curr, ans, a, des);
            curr.removeLast();
        }
    }
}