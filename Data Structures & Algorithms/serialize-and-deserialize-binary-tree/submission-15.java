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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                sb.append('N').append(',');
                continue;
            }

            sb.append(node.val).append(',');
            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int preIdx = 0;
        String[] nodes = data.split(",");
        String val = nodes[preIdx++];

        if ("N".equals(val)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            node.left = ("N".equals(nodes[preIdx])) ? null : new TreeNode(Integer.parseInt(nodes[preIdx]));
            preIdx++;

            node.right = ("N".equals(nodes[preIdx])) ? null : new TreeNode(Integer.parseInt(nodes[preIdx]));
            preIdx++;

            if (node.left != null) {
                q.offer(node.left);
            }

            if (node.right != null) {
                q.offer(node.right);
            }
        }

        return root;
    }
}
