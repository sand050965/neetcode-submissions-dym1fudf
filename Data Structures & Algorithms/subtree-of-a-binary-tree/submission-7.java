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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return false;
        }

        boolean result = dfs(node1.left, node2) || dfs(node1.right, node2);

        if (node1.val == node2.val) {
            result |= isSameTree(node1, node2);
        }

        return result;
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        return node1.val == node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
}
