class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return (l < n && nums[l] == target) ? l : -1;
    }
}
