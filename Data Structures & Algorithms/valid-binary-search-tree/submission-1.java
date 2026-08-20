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
        if (root == null) return true;

        Deque<Object[]> dq = new ArrayDeque<>();
        dq.offer(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});
        
        while(!dq.isEmpty()) {
            Object[] ob = dq.poll();
            TreeNode node = (TreeNode) ob[0];
            int min = (int) ob[1], max = (int) ob[2];

            if (node.val <= min || node.val >= max) return false;

            if (node.left != null)
                dq.offer(new Object[]{node.left, min, node.val});

            if(node.right != null)
                dq.offer(new Object[]{node.right, node.val, max});
        }

        return true;
    }
}
