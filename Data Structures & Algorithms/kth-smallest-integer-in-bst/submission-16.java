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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                k--;
                if (k == 0) {
                    return curr.val;
                }
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;

                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    k--;
                    if (k == 0) {
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }

        return -1;
    }
}
