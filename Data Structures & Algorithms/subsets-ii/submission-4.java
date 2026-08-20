class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);

        backtrack(nums, 0);

        return result;
    }

    private void backtrack(int[] nums, int idx) {
        result.add(new ArrayList<>(path));

        for (int i = idx; i < n; i++) {
            int num = nums[i];
            if (i > idx && nums[i - 1] == num) {
                continue;
            }

            path.add(num);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
