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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return result;
        }

        Queue<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while (!dq.isEmpty()) {
            for (int i = dq.size(); i > 0; i--) {
                TreeNode node = dq.poll();
                if (i == 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    dq.offer(node.left);
                }

                if (node.right != null) {
                    dq.offer(node.right);
                }
            }
        }

        return result;
    }
}
