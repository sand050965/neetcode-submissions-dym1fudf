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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return node;
        }

        if (node.val > Math.max(p.val, q.val)) {
            return dfs(node.left, p, q);
        } else if (node.val < Math.min(p.val, q.val)) {
            return dfs(node.right, p, q);
        }

        return node;
    }
}
