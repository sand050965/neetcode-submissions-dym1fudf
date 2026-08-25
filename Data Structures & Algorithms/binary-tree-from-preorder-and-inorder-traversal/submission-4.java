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
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return recurse(preorder, inorder, 0, inorder.length);
    }

    private TreeNode recurse(int[] preorder, int[] inorder, int left, int right) {
        if (preIdx >= preorder.length) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIdx++]);
        int idx = findIdx(inorder, node.val, left, right);
        int leftSize = idx - left, rightSize = right - idx;

        node.left = (leftSize <= 0) ? null : recurse(preorder, inorder, left, idx - 1);
        node.right = (rightSize <= 0) ? null : recurse(preorder, inorder, idx + 1, right);

        return node;
    }

    private int findIdx(int[] arr, int target, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
