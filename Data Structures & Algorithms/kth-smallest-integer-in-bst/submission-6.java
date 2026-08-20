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
    int cnt;

    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        dfs(root);

        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null || cnt <= 0) {
            return;
        }

        dfs(node.left);
        
        cnt--;
        if (cnt == 0) {
            result = node.val;
            return;
        }

        dfs(node.right);
    }
}
