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
        Queue<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();

            if (node == null) {
                sb.append("N").append(",");
                continue;
            }

            sb.append(node.val).append(",");

            dq.offer(node.left);
            dq.offer(node.right);
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int idx = 0;
        if (nodes[idx].equals("N")) {
            return null;
        }

        Queue<TreeNode> dq = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx]));
        dq.offer(root);
        idx++;


        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            if (!nodes[idx].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(nodes[idx]));
                dq.offer(node.left);
            }
            idx++;
            
            if (!nodes[idx].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(nodes[idx]));
                dq.offer(node.right);
            }
            idx++;
        }

        return root;
    }
}
