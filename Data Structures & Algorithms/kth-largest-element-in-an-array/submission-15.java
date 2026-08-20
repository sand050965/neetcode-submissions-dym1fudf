class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;

        return quickSelect(nums, target, 0, n - 1);
    }
    
    private int quickSelect(int[] nums, int target, int l, int r) {
        int curr = l;
        int pivot = nums[r];

        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, curr);
                curr++;
            }
        }

        swap(nums, curr, r);

        if (curr > target) {
            return quickSelect(nums, target, l, curr - 1);
        } else if (curr < target) {
            return quickSelect(nums, target, curr + 1, r);
        } else {
            return pivot;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
