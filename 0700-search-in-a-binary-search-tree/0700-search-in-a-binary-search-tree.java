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
    public TreeNode searchBST(TreeNode root, int val) {
        // Approach - 1 -> Iterative Approach
        // TreeNode curr = root;
        // while(curr != null) {
        //     if(curr.val == val) return curr;
        //     else if(val < curr.val) curr = curr.left;
        //     else curr = curr.right;
        // }
        // return null;

        // Approach - 2 -> Recursive Approach
        if(root == null || root.val == val) return root;
        if(val < root.val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}