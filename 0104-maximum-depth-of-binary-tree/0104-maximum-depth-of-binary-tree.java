class Solution {
    public int maxDepth(TreeNode root) {
        // if(root == null) return 0;
        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        //Another Method
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}