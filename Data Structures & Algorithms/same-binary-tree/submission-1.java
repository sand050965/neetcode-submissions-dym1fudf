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
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();

            TreeNode nodeP = nodes[0];
            TreeNode nodeQ = nodes[1];

            if (nodeP == null && nodeQ == null) continue;
            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) return false;

            stack.push(new TreeNode[]{nodeP.right, nodeQ.right});
            stack.push(new TreeNode[]{nodeP.left, nodeQ.left});
        }

        return true;
    }
}
