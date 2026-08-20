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

public class Codec {
    StringBuilder sb = new StringBuilder();
    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSerial(root);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private void dfsSerial(TreeNode node) {
        if (node == null) {
            sb.append("null").append(",");
            return;
        }

        sb.append(node.val).append(',');
        dfsSerial(node.left);
        dfsSerial(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return dfsDeserial(data.split(","));
    }

    private TreeNode dfsDeserial(String[] preorder) {
        if (idx >= preorder.length) {
            return null;
        }

        if (preorder[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(preorder[idx++]));
        node.left = dfsDeserial(preorder);
        node.right = dfsDeserial(preorder);

        return node;
    }
}
