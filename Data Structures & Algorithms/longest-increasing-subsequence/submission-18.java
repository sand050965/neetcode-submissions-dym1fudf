class SegmentTree {
    class TreeNode {
        int start, end, max;
        TreeNode left, right;
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.max = max;
        }
    }

    TreeNode root;

    public SegmentTree(int n) {
        root = build(0, n - 1);
    }

    private TreeNode build(int start, int end) {
        TreeNode node = new TreeNode(start, end);
        if (start == end) {
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = build(start, mid);
        node.right = build(mid + 1, end);

        return node;
    }

    public void update(TreeNode node, int idx, int val) {
        if (node.start == idx && node.end == idx) {
            node.max = val;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (idx <= mid) {
            update(node.left, idx, val);
        } else {
            update(node.right, idx, val);
        }

        node.max = Math.max(node.left.max, node.right.max);
    }

    public int query(TreeNode node, int l, int r) {
        if (node.start == l && node.end == r) {
            return node.max;
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
        int[] sorted = Arrays.stream(nums).distinct().sorted().toArray();
        int n = sorted.length;
        int result = 0;
        SegmentTree tree = new SegmentTree(n);
        for (int num : nums) {
            int rank = Arrays.binarySearch(sorted, num);
            int best = (rank == 0) ? 0 : tree.query(tree.root, 0, rank - 1);
            int curr = best + 1;
            tree.update(tree.root, rank, curr);
            result = Math.max(result, curr);
        }

        return result;
    }
}
