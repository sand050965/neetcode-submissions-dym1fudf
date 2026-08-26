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
            return false;
        }
        
        Queue<Pair<TreeNode, int[]>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));

        while (!q.isEmpty()) {
            Pair<TreeNode, int[]> pair = q.poll();
            TreeNode node = pair.getKey();
            int[] limits = pair.getValue();
            int leftLimit = limits[0], rightLimit = limits[1];

            if (node.val <= leftLimit || node.val >= rightLimit) {
                return false;
            }

            if (node.left != null) {
                q.offer(new Pair<>(node.left, new int[] {leftLimit, Math.min(rightLimit, node.val)}));
            }

            if (node.right != null) {
                q.offer(new Pair<>(node.right, new int[] {Math.max(leftLimit, node.val), rightLimit}));
            }
        }

        return true;
    }
}
