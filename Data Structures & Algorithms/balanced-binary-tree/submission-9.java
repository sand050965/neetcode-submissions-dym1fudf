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
        map.put(null, 0);

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();

                if (node.right == null || last == node.right) {
                    stack.pop();

                    int leftHeight = map.get(node.left), rightHeight = map.get(node.right);

                    if (Math.abs(leftHeight - rightHeight) > 1) {

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
