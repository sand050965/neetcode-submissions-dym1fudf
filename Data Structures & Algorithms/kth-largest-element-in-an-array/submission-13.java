class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        
        int idx = quickSelect(nums, n - k, 0, n - 1);

        return nums[idx];
    }

    private int quickSelect(int[] nums, int k, int l, int r) {
        int pivot = r;
        int p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[pivot]) {
                continue;
            }
            
            swap(nums, i, p);
            p++;
        }

        swap(nums, p, pivot);

        if (p < k) {
            return quickSelect(nums, k, p + 1, r);
        } else if (p > k) {
            return quickSelect(nums, k, l, p - 1);
        } else {
            return p;
        }
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
