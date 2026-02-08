class Solution {
    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    } 
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}