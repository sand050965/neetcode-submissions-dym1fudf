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
        Queue<Pair<TreeNode, int[]>> q = new LinkedList<>(); // {left, right}
        q.offer(new Pair<>(root, new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));
        while (!q.isEmpty()) {
            Pair<TreeNode, int[]> curr = q.poll();
            TreeNode node = curr.getKey();
            int[] boundaries = curr.getValue();
            int left = boundaries[0];
            int right = boundaries[1];

            if (node.val <= left || node.val >= right) {
                return false;
            }

            if (node.left != null) {
                q.offer(new Pair<>(node.left, new int[]{left, node.val}));
            }

            if (node.right != null) {
                q.offer(new Pair<>(node.right, new int[]{node.val, right}));
            }
        }

        return true;
    }
}
