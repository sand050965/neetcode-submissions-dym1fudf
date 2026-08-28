class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int target = n - k;
        return quickSelect(nums, target, l, r);
    }

    private int quickSelect(int[] nums, int target, int l, int r) {
        int pivot = r, p = l;

        for (int i = l; i < r; i++) {
            if (nums[i] <= nums[pivot]) {
                swap(nums, i, p);
                p++;
            }
        }

        swap(nums, pivot, p);

        if (p > target) {
            return quickSelect(nums, target, l, p - 1);
        } else if (p < target) {
            return quickSelect(nums, target, p + 1, r);
        }

        return nums[p];
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
