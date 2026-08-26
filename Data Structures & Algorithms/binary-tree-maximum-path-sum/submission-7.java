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
    int max = 0;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = dfs(node.left), rightSum = dfs(node.right);
        int sum = node.val + Math.max(leftSum + rightSum, Math.max(leftSum, rightSum));
        max = Math.max(max, sum);

        return Math.max(0, node.val + Math.max(leftSum, rightSum));
    }
}
