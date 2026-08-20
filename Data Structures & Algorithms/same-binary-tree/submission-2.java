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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode nodeP, TreeNode nodeQ) {
        if (nodeP == null && nodeQ == null) {
            return true;
        }

        if ((nodeP == null && nodeQ != null)
            || (nodeP != null && nodeQ == null)
            || (nodeP.val != nodeQ.val)
        ) {
            return false;
        }

        boolean isSameLeft = dfs(nodeP.left, nodeQ.left);
        boolean isSameRight = dfs(nodeP.right, nodeQ.right);

        return (isSameLeft && isSameRight);
    }
}
