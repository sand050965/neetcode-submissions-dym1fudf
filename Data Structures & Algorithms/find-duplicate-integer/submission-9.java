class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                return num;
            }

            nums[num - 1] = -nums[num - 1];
        }

        return -1;
    }
}
