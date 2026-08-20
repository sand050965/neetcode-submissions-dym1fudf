class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int start, int end, int[] nums, int target) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return mid;

        return (nums[mid] < target) ?
            binarySearch(mid + 1, end, nums, target) :
            binarySearch(start, mid - 1, nums, target);
    }
}
