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
    int k = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);

        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        k--;

        if (k == 0) {
            result = node.val;
        }

        dfs(node.right);
    }
}
