class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = num + nums[l] + nums[r];

                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    result.add(List.of(num, nums[l], nums[r]));
                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }

        return result;
    }
}
