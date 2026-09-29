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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixCount);
    }
    private int dfs(TreeNode node, long curSum, int target, Map<Long, Integer> prefixCount) {
        if (node == null) return 0;

        curSum += node.val;
        int count = prefixCount.getOrDefault(curSum - target, 0);

        prefixCount.merge(curSum, 1, Integer::sum);
        count += dfs(node.left, curSum, target, prefixCount);
        count += dfs(node.right, curSum, target, prefixCount);
        prefixCount.merge(curSum, -1, Integer::sum); // backtrack

        return count;
    }
}