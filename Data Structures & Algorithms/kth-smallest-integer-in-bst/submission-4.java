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
    List<TreeNode> result = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return (result.size() > 0 || result.size() >= k) 
                ? result.get(k - 1).val
                : -1;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null || result.size() == k) {
            return;
        }

        dfs(node.left, k);
        result.add(node);
        dfs(node.right, k);
    }
}
