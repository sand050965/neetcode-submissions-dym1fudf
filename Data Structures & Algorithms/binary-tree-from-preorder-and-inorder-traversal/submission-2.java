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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int nodeVal = preorder[preStart];
        int inIdx = findIdx(inorder, nodeVal);
        int leftSize = inIdx - inStart;
        int rightSize = inEnd - inIdx;

        TreeNode node = new TreeNode(nodeVal);
        node.left = dfs(preorder, inorder, preStart + 1, preStart + leftSize, inStart, inIdx - 1);
        node.right = dfs(preorder, inorder, preStart + leftSize + 1, preEnd, inIdx + 1, inEnd);

        return node;
    }

    private int findIdx(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target) {
                continue;
            }

            return i;
        }

        return -1;
    }
}
