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

            int leftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int rightA = (partitionA >= m) ? Integer.MAX_VALUE : nums1[partitionA];
            int leftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int rightB = (partitionB >= n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (leftA <= rightB && leftB <= rightA) {
                return (total % 2 != 0) ?
                    Math.min(rightA, rightB) :
                    (double) (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2;
            } else if (leftA > rightB) {
                r = partitionA - 1;
            } else {
                l = partitionA + 1;
            }
        }

        return 0.0;
    }
}
