class Solution {
    private Map<Integer, Integer> inorderIndex = new HashMap<>();
    private int postIndex;
    public TreeNode divide(int[] postorder, int left, int right) {
        if (left > right) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderIndex.get(rootVal);

        root.right = divide(postorder, mid + 1, right);
        root.left  = divide(postorder, left, mid - 1);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return divide(postorder, 0, inorder.length - 1);
    }
}