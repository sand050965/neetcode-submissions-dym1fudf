class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int result = nums[left];

        while (left <= right) {
            if (nums[left] < nums[right]) {
                result = Math.min(result, nums[left]);
                break;
            }

            int mid = left + (right - left) / 2;
            result = Math.min(result, nums[mid]);
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
