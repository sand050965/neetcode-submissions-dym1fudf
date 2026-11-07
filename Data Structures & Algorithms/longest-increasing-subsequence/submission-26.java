class Solution {
    public int lengthOfLIS(int[] nums) {
        int LIS = 1;
        int n = nums.length;
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (dp.getLast() < num) {
                dp.add(num);
                LIS++;
                continue;
            }

            int idx = Collections.binarySearch(dp, num);
            if (idx < 0) {
                idx = -idx - 1;
            }
            dp.set(idx, num);
        }

        return LIS;
    }
}
