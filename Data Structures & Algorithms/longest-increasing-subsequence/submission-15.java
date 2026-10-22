class SegmentTree {
    int n;
    int[] tree;

    public SegmentTree(int n) {
        this.n = n;
        while ((n & (n - 1)) != 0) {
            n++;
        }
        tree = new int[2 * n];
    }

    public void update(int i, int val) {
        tree[n + i] = val;
        int j = (n + i) / 2;
        while (j >= 1) {
            tree[j] = Math.max(tree[2 * j], tree[(2 * j) + 1]);
            j /= 2;
        }
    }

    public int query(int l, int r) {
        if (l > r) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        l += n;
        r += (n + 1);

        while (l < r) {
            if (l % 2 != 0) {
                result = Math.max(result, tree[l]);
                l++;
            }

            if (r % 2 != 0) {
                r--;
                result = Math.max(result, tree[r]);
            }

            l /= 2;
            r /= 2;
        }

        return result;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int result = 0;
        int[] orders = new int[n];
        int[] sortedArr = Arrays.stream(nums).distinct().sorted().toArray();
        int m = sortedArr.length;
        SegmentTree segmentTree = new SegmentTree(m);
        for (int i = 0; i < n; i++) {
            orders[i] = Arrays.binarySearch(sortedArr, nums[i]);
        }

        for (int order : orders) {
            int LIS = segmentTree.query(0, order - 1) + 1;
            segmentTree.update(order, LIS);
            result = Math.max(result, LIS);
        }

        return result;
    }
}
