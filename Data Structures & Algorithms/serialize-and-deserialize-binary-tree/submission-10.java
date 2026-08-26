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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('N').append(',');
            return;
        }

        sb.append(node.val).append(',');
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        return dfsDeserialize(nodes, new int[] {0});
    }

    private TreeNode dfsDeserialize(String[] nodes, int[] preIdx) {
        if ("N".equals(nodes[preIdx[0]])) {
            preIdx[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[preIdx[0]++]));
        node.left = dfsDeserialize(nodes, preIdx);
        node.right = dfsDeserialize(nodes, preIdx);

        return node;
    }
}
