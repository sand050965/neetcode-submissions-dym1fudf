class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n, half = total / 2;
        int l = 0, r = m;
        while (l <= r) {
            int partitionA = l + (r - l) / 2;
            int partitionB = half - partitionA;

            int ALeft = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int ARight = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int BLeft = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int BRight = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (ALeft <= BRight && BLeft <= ARight) {
                return (total % 2 != 0)?
                    (double) Math.min(ARight, BRight) :
                    (double) (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2;
            } else if (ALeft > BRight) {
                r = partitionA - 1;
            } else {
                l = partitionA + 1;
            }
        }

        return 0.0;
    }
}
