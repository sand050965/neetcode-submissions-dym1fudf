class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int rob1 = 0, rob2 = 0;
        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
