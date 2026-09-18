class Solution {
    int n;
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        recurse(nums, 0);

        return result;
    }

    private void recurse(int[] nums, int idx) {
        result.add(new ArrayList<>(subset));

        for (int i = idx; i < n; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            int num = nums[i];
            subset.add(num);
            recurse(nums, i + 1);
            subset.removeLast();
        }
    }
}
