class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int max_val = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max_val = Math.max(max_val, node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            ans.add(max_val);
        }
        return ans;
    }
}