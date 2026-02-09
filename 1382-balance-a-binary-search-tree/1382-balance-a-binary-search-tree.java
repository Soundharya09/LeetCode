class Solution {
    public void inorder(TreeNode node, List<Integer> val) {
        if(node == null) return;
        inorder(node.left, val);
        val.add(node.val);
        inorder(node.right, val);
    }
    public TreeNode build(List<Integer> val, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(val.get(mid));
        node.left  = build(val, l, mid - 1);
        node.right = build(val, mid + 1, r);
        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return build(ans, 0, ans.size() - 1);
    } 
}