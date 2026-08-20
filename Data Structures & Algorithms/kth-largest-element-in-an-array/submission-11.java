class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;

        return quickSelect(nums, k, 0, n - 1);
    }

    private int quickSelect(int[] nums, int k, int l, int r) {
        int pivot = nums[r];
        int p = l;
        int idx = l;
        while (idx < r) {
            if (nums[idx] <= pivot) {
                swap(nums, p, idx);
                p++;
            }

            idx++;
        }

        swap(nums, p, r);

        if (p > k) {
            return quickSelect(nums, k, l, p - 1);
        } else if (p < k) {
            return quickSelect(nums, k, p + 1, r);
        }

        return nums[p];
    }

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
