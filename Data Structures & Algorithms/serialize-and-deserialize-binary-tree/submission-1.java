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
        dfs(root, sb);

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(String.valueOf(node.val)).append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] idx = {0};
        return dfs(data.split(","), idx);
    }

    private TreeNode dfs(String[] arr, int[] idx) {
        if ("N".equals(arr[idx[0]])) return null;

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx[0]]));
        idx[0]++;
        node.left = dfs(arr, idx);
        idx[0]++;
        node.right = dfs(arr, idx);

        return node;
    }
}
