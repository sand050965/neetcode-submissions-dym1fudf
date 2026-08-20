class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        int pivot = l;
        l = 0;
        r = n - 1;

        return (nums[pivot] <= target && target <= nums[r]) ?
            binarySearch(nums, target, pivot, r) :
            binarySearch(nums, target, l, pivot - 1);
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
