class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int l = 0, r = n - 1;
        int result = nums[l];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                result = Math.min(result, nums[l]);
                break;
            }

            int mid = l + (r - l) / 2;
            result = Math.min(result, nums[mid]);
            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
