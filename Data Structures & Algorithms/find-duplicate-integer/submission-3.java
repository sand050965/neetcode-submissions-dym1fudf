class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int lessOrEqual = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) lessOrEqual++;
            }

            if (lessOrEqual <= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
