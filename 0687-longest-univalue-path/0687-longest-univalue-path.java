/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPath;
    }
    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);
        int leftExtend = 0;
        int rightExtend = 0;
        if (node.left != null && node.left.val == node.val) leftExtend = leftPath + 1;
        if (node.right != null && node.right.val == node.val) rightExtend = rightPath + 1;
        maxPath = Math.max(maxPath, leftExtend + rightExtend);
        return Math.max(leftExtend, rightExtend);
    }
}