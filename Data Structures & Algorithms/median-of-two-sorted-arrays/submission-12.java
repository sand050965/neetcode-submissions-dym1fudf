class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n, half = total / 2;
        int l = 0, r = m;

        while (l <= r) {
            int partition1 = l + (r - l) / 2;
            int partition2 = half - partition1;

            int left1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = (partition1 < m) ? nums1[partition1] : Integer.MAX_VALUE;
            int left2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = (partition2 < n) ? nums2[partition2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                return (total % 2 == 1) ?
                    Math.min(right1, right2) :
                    (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }

            if (left1 < right2) {
                l = partition1 + 1;
            } else {
                r = partition1 - 1;
            }
        }

        return 0.0;
    }
}
