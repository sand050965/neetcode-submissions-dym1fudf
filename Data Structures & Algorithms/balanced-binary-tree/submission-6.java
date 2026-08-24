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
    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        TreeNode node = root, last = null;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right == null || last == node.right) {
                    stack.pop();
                    int leftHeight = map.getOrDefault(node.left, 0);
                    int rightHeight = map.getOrDefault(node.right, 0);
                    boolean isBalanced = (Math.abs(leftHeight - rightHeight) <= 1);

                    if (!isBalanced) {
                        return false;
                    }

                    map.put(node, 1 + Math.max(leftHeight, rightHeight));
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }

        return true;
    }
}
