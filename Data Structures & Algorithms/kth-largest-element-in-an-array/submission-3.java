class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int left, int right) {
        int pivot = nums[right], pointer = left;

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, pointer, i);
                pointer++;
            }
        }
        swap(nums, pointer, right);

        if (pointer == k) return nums[pointer];

        return (k < pointer) ?
            quickSelect(nums, k, left, pointer - 1) :
            quickSelect(nums, k, pointer + 1, right);
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
