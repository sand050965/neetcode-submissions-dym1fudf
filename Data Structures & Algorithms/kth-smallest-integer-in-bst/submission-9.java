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
    public int kthSmallest(TreeNode root, int k) {
        int[] result = {0, k};
        dfs(root, result);

        return result[0];
    }

    private void dfs(TreeNode node, int[] result) {
        if (node == null) {
            return;
        }

        dfs(node.left, result);

        result[1]--;
        if (result[1] == 0) {
            result[0] = node.val;
            return;
        }

        dfs(node.right, result);
    }
}
