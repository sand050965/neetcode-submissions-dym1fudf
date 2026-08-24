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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> dq = new ArrayDeque<>();
        dq.offer(new TreeNode[] {p, q});

        while (!dq.isEmpty()) {
            TreeNode[] nodes = dq.poll();
            TreeNode node1 = nodes[0], node2 = nodes[1];

            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            dq.offer(new TreeNode[]{node1.left, node2.left});
            dq.offer(new TreeNode[]{node1.right, node2.right});
        }

        return true;
    }
}
