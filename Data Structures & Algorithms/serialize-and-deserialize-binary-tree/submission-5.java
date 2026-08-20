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
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append("N").append(',');
                    continue;
                }

                sb.append(node.val).append(',');
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int idx = 0;
        String val = vals[idx++];
        if ("N".equals(val)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            String leftVal = vals[idx++];
            if (!"N".equals(leftVal)) {
                node.left = new TreeNode(Integer.parseInt(leftVal));
                q.offer(node.left);
            }

            String rightVal = vals[idx++];
            if (!"N".equals(rightVal)) {
                node.right = new TreeNode(Integer.parseInt(rightVal));
                q.offer(node.right);
            }
        }

        return root;      
    }
}
