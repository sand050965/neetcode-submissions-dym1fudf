class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, LIS = 1;
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (dp.get(dp.size() - 1) < num) {
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
