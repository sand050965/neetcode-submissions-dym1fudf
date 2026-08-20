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
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null)
            || (p != null && q == null)
            || (p.val != q.val)) {
                return false;
        }

        Queue<TreeNode> dqP = new LinkedList<>();
        Queue<TreeNode> dqQ = new LinkedList<>();
        dqP.offer(p);
        dqQ.offer(q);

        while (!dqP.isEmpty() && !dqQ.isEmpty()) {
            if (dqP.size() != dqQ.size()) {
                return false;
            }

            for (int i = dqP.size(), j = dqQ.size(); i > 0 && j > 0; i--, j--) {
                TreeNode nodeP = dqP.poll();
                TreeNode nodeQ = dqQ.poll();

                if (nodeP == null && nodeQ == null) {
                    continue;
                }

                if (nodeP == null || nodeQ == null || (nodeP.val != nodeQ.val)) {
                    return false;
                }


                dqP.offer(nodeP.left);
                dqP.offer(nodeP.right);
                dqQ.offer(nodeQ.left);
                dqQ.offer(nodeQ.right);
            }
        }

        return true;
    }
}
