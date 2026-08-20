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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Pair<Boolean, Integer> result = dfs(root);

        return result.getKey();
    }

    private Pair<Boolean, Integer> dfs(TreeNode node) {
        if (node == null) {
            return new Pair<>(true, 0);
        }

        Pair<Boolean, Integer> left = dfs(node.left);
        Pair<Boolean, Integer> right = dfs(node.right);
        int diff = Math.abs(left.getValue() - right.getValue());
        boolean isBalanced = left.getKey() 
                            && right.getKey()
                            && (diff <= 1);
        
        return new Pair<>(isBalanced, 1 + Math.max(left.getValue(), right.getValue()));
    }
}
