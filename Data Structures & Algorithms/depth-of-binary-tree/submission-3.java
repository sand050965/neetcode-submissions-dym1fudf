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

        // TreeNode root => count the max depth of the given tree
        // int => return the max depth as the result

        // BFS or DFS
        // DFS
        // recursive
        // traverse from root
        // visit the curr node
        // recursively traverse to the left and right childre ndoes
        // increment the depth by 1
        // max(left depth, right depth)
        // return

        // base case: repeat until reach the end of the tree

        // O(N)
        // O(h)
        // N => the size of the tree
        // h => the max height of the tree

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
