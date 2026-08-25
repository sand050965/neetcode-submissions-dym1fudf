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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while (!dq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = dq.size(); i > 0; i--) {
                TreeNode node = dq.poll();
                list.add(node.val);

                if (node.left != null) {
                    dq.offer(node.left);
                }

                if (node.right != null) {
                    dq.offer(node.right);
                }
            }

            result.add(list);
        }

        return result;
    }
}
