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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, int leftLimit, int rightLimit) {
        if (node == null) {
            return true;
        }

        if (node.val <= leftLimit || node.val >= rightLimit) {
            return false;
        }

        return dfs(node.left, leftLimit, Math.min(rightLimit, node.val)) && dfs(node.right, Math.max(leftLimit, node.val), rightLimit);
    }
}
