class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1, currLevel = 1;
        while(!q.isEmpty()) {
            int levelSize = q.size();
            int levelSum = 0;
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                levelSum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currLevel;
            }
            currLevel++;
        }
        return maxLevel;
    }
}