class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = n1 + n2, half = total / 2;
        int l = 0, r = n1;

        while (l <= r) {
            int mid1 = l + (r - l) / 2;
            int mid2 = half - mid1;

            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int right1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                return (total % 2 == 1) ? Math.min(right1, right2) : (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                r = mid1 - 1;
            } else if (left2 > right1) {
                l = mid1 + 1;
            }
        }
        
        return 0.0;
    }
}
