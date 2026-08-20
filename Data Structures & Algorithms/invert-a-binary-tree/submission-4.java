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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return node;
        }

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        TreeNode leftNode = dfs(node.left);
        TreeNode rightNode = dfs(node.right);

        return node;
    }
}
