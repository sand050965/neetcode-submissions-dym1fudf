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
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return result;
    }

    private int dfs(TreeNode node, int k) {
        if (node == null || k <= 0) {
            return k;
        }

        k = dfs(node.left, k);
        k -= 1;

        if (k == 0) {
            result = node.val;
            return k;
        }

        k = dfs(node.right, k);

         return k;
    }
}
