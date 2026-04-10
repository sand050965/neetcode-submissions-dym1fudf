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

    private boolean dfs(TreeNode node, TreeNode subNode) {
        if (subNode == null) {
            return true;
        }

        if (node == null) {
            return false;
        }

        boolean result = false;
        if (node.val == subNode.val) {
            result = isSameTree(node, subNode);
        }

        return result || dfs(node.left, subNode) || dfs(node.right, subNode);
    }

    private boolean isSameTree(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) {
            return true;
        }

        if (node == null || subNode == null || node.val != subNode.val) {
            return false;
        }

        return isSameTree(node.left, subNode.left) && isSameTree(node.right, subNode.right);
    }
}
