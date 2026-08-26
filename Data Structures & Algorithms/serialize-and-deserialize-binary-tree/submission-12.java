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
        if ("N".equals(nodes[preIdx])) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[preIdx++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            String leftVal = nodes[preIdx++], rightVal = nodes[preIdx++];

            node.left = ("N".equals(leftVal)) ? null : new TreeNode(Integer.parseInt(leftVal));
            node.right = ("N".equals(rightVal)) ? null : new TreeNode(Integer.parseInt(rightVal));

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
