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
    public boolean isBalanced(TreeNode root) {
        return dfs(root).getValue();
    }

    private Pair<Integer, Boolean> dfs(TreeNode node) {
        if (node == null) {
            return new Pair<>(0, true);
        }

        Pair<Integer, Boolean> leftPair = dfs(node.left), rightPair = dfs(node.right);
        int leftHeight = leftPair.getKey(), rightHeight = rightPair.getKey();

        boolean result = (Math.abs(leftHeight - rightHeight) <= 1) && leftPair.getValue() && rightPair.getValue();

        return new Pair<>(1 + Math.max(leftHeight, rightHeight), result);
    }
}
