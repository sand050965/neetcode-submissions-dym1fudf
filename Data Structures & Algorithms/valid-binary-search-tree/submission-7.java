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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<Pair<TreeNode, int[]>> dq = new ArrayDeque<>();
        dq.offer(new Pair<>(root, new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));

        while (!dq.isEmpty()) {
            Pair<TreeNode, int[]> pair = dq.poll();
            TreeNode node = pair.getKey();
            int[] boundaries = pair.getValue();
            int leftBoundary = boundaries[0], rightBoundary = boundaries[1];

            if (node.val <= leftBoundary || node.val >= rightBoundary) {
                return false;
            }

            if (node.left != null) {
                dq.offer(new Pair<>(node.left, new int[] {leftBoundary, node.val}));
            }

            if (node.right != null) {
                dq.offer(new Pair<>(node.right, new int[] {node.val, rightBoundary}));
            }
        }

        return true;
    }
}
