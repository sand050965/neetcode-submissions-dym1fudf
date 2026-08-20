class Solution {
    public int search(int[] nums, int target) {
        // LowerBound

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target <= nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return (nums[l] == target) ? l : -1;
    }
}
