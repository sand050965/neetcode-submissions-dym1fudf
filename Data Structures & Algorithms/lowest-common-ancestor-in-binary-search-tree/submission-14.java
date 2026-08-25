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
        if (root == null || p == null || q == null) {
            return null;
        }

        TreeNode curr = root;
        while (curr != null) {
            if (Math.max(p.val, q.val) < curr.val) {
                curr = curr.left;
                continue;
            }

            if (curr.val < Math.min(p.val, q.val)) {
                curr = curr.right;
                continue;
            }

            return curr;
        }

        return null;
    }
}
