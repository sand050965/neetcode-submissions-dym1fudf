class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        if (B.length < A.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }

        int total = A.length + B.length;
        int half = (total + 1) / 2;
        int l = 0, r = A.length;

        while (l <= r) {
            int partitionA = l + (r - l) / 2;
            int partitionB = half - partitionA;

            int leftA = (partitionA > 0) ? A[partitionA - 1] : Integer.MIN_VALUE;
            int rightA = (partitionA < A.length) ? A[partitionA] : Integer.MAX_VALUE;
            int leftB = (partitionB > 0) ? B[partitionB - 1] : Integer.MIN_VALUE;
            int rightB = (partitionB < B.length) ? B[partitionB] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                return (total % 2 == 1) ?
                    Math.max(leftA, leftB) :
                    (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
            } else if (rightB < leftA) {
                r = partitionA - 1;
            } else {
                l = partitionA + 1;
            }
        }

        return -1;
    }
}
