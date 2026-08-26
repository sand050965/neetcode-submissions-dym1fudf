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
    public int goodNodes(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }    

        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, Integer.MIN_VALUE));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            int max = pair.getValue();

            if (node.val >= max) {
                result++;
            }

            max = Math.max(max, node.val);

            if (node.left != null) {
                q.offer(new Pair<>(node.left, max));
            }

            if (node.right != null) {
                q.offer(new Pair<>(node.right, max));
            }
        }

        return result;
    }
}
