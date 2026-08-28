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

        if (p == target) {
            return nums[p];
        }

        if (p > target) {
            r = p - 1;
        } 
        
        if (p < target) {
            l = p + 1;
        }

        return quickSelect(nums, target, l, r);
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
