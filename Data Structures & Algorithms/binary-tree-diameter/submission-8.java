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
    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, int[]> map = new HashMap<>();
        TreeNode node = root, last = null;
        map.put(null, new int[] {0, 0});

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right == null || last == node.right) {
                    stack.pop();
                    int[] leftData = map.get(node.left), rightData = map.get(node.right);
                    int leftHeight = leftData[0], leftDiameter = leftData[1];
                    int rightHeight = rightData[0], rightDiameter = rightData[1];

                    int height = 1 + Math.max(leftHeight, rightHeight);
                    int diameter = Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
                    map.put(node, new int[] {height, diameter});
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }

        return map.get(root)[1];
    }
}
