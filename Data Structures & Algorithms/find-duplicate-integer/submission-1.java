class Solution {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return Math.abs(num);
            }
            nums[idx] *= -1;
        }

        return -1;
    }
}
