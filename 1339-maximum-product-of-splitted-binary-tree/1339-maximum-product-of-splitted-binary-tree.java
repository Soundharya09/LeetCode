class Solution {
    long totalSum = 0, maxProd = 0;
    static int MOD = 1_000_000_007;
    long getTotal(TreeNode root) {
        if(root == null) return 0;
        return root.val + getTotal(root.left) + getTotal(root.right);
    }
    public long dfs(TreeNode root) {
        if(root == null) return 0;
        long left = dfs(root.left);
        long right = dfs(root.right);
        long subTreeSum = root.val + left + right;
        long product = subTreeSum * (totalSum - subTreeSum);
        
        maxProd = Math.max(maxProd, product);
        return subTreeSum;
    }
    public int maxProduct(TreeNode root) {
        totalSum = getTotal(root);
        dfs(root);
        return (int)(maxProd % MOD);

    }
}