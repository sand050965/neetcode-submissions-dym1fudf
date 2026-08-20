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

        if (isSameTree(node, subNode)) {
            return true;
        }

        return dfs(node.left, subNode) || dfs(node.right, subNode);
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        return isSameTree(node1.left, node2.left) 
                && isSameTree(node1.right, node2.right);
    }
}
