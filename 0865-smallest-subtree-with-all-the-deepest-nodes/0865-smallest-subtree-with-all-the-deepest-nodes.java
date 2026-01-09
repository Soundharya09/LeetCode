class Solution {
    private static class Pair {
        int depth;
        TreeNode lca;
        Pair(int depth, TreeNode lca) {
            this.depth = depth;
            this.lca = lca;
        }
    }
    public Pair findLcaAndDepth(TreeNode node) {
        if(node == null) return new Pair(0, null);
        // Leaf Node
        if(node.left == null && node.right == null) return new Pair(1, node);
        Pair left = findLcaAndDepth(node.left);
        Pair right = findLcaAndDepth(node.right);
        int maxDepth = Math.max(left.depth, right.depth);
        TreeNode currLca;

        if(left.depth == right.depth) currLca = node;
        else if(left.depth > right.depth) currLca = left.lca;
        else currLca = right.lca;

        return new Pair(maxDepth + 1, currLca);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return findLcaAndDepth(root).lca;
    }
}