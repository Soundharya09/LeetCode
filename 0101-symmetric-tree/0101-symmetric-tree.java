class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return  Mirror(root.left, root.right);
    }
    public boolean Mirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return Mirror(left.left, right.right) && Mirror(left.right, right.left);   
    }
}