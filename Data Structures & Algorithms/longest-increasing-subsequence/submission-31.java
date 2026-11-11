class SegmentTree {
    class TreeNode {
        int start, end, lis;
        TreeNode left, right;

        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    TreeNode root;

    SegmentTree(int n) {
        root = build(0, n - 1);
    }

    TreeNode build(int start, int end) {
        TreeNode node = new TreeNode(start, end);
        if (start == end) {
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = build(start, mid);
        node.right = build(mid + 1, end);

        return node;
    }

    void update(TreeNode node, int idx, int lis) {
        if (node.start == idx && node.end == idx) {
            node.lis = lis;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (idx <= mid) {
            update(node.left, idx, lis);
        } else {
            update(node.right, idx, lis);
        }

        node.lis = Math.max(node.left.lis, node.right.lis);
    }

    int query(TreeNode node, int l, int r) {
        if (node.start == l && node.end == r) {
            return node.lis;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (r <= mid) {
            return query(node.left, l, r);
        } else if (l > mid) {
            return query(node.right, l, r);
        }

        return Math.max(query(node.left, l, mid), query(node.right, mid + 1, r));
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = Arrays.stream(nums).distinct().sorted().toArray();
        int n = arr.length;
        SegmentTree segmentTree = new SegmentTree(n);

        for (int num : nums) {
            int rank = Arrays.binarySearch(arr, num);
            int preLis = (rank == 0) ? 0 : segmentTree.query(segmentTree.root, 0, rank - 1);
            int lis = 1 + preLis;
            segmentTree.update(segmentTree.root, rank, lis);
        }

        return segmentTree.root.lis;
    }
}
