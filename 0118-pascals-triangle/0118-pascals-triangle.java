class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        for(int i=0; i<n; i++){
            List<Integer> a = new ArrayList<>();
            for(int j=0; j<=i; j++){
                a.add(1);
            }
            ans.add(a);
        }
        for(int i=2; i<n; i++){
            for(int j=1; j<i; j++){
                ans.get(i).set(j, ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
            }
        }
        return ans;
    }
}