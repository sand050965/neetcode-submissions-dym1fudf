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
        if (root == null) return "N";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("N,");
                continue;
            }

            sb.append(String.valueOf(node.val)).append(",");
            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.deleteCharAt(sb.length() - 1).toString();    
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int idx = 0;
        String[] arr = data.split(",");
        if ("N".equals(arr[0])) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"N".equals(arr[idx])) {
                node.left = new TreeNode(Integer.parseInt(arr[idx]));
                queue.add(node.left);
            }
            idx++;
            if (!"N".equals(arr[idx])) {
                node.right = new TreeNode(Integer.parseInt(arr[idx]));
                queue.add(node.right);
            }
            idx++;
        }

        return root;
    }
}
