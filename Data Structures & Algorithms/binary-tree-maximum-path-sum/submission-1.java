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
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{root.val};
        dfs(root, result);
        
        return result[0];
    }

    private int dfs(TreeNode root, int[] result) {
        if (root == null) return 0;

        int leftMax = dfs(root.left, result);
        int rightMax = dfs(root.right, result);
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        result[0] = Math.max(result[0], root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}
