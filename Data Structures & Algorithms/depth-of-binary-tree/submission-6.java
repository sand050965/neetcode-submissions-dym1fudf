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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        int result = 0;

        while (!dq.isEmpty()) {
            for (int i = dq.size(); i > 0; i--) {
                TreeNode node = dq.poll();

                if (node.left != null) {
                    dq.offer(node.left);
                }

                if (node.right != null) {
                    dq.offer(node.right);
                }
            }

            result++;
        }

        return result;
    }
}
