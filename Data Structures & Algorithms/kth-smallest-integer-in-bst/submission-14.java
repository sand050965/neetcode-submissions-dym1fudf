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
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return result;
    }

    private int dfs(TreeNode node, int k) {
        if (node == null) {
            return k;
        }

        k = dfs(node.left, k);
        k--;

        if (k == 0) {
            result = node.val;
        }

        return dfs(node.right, k);
    }
}
