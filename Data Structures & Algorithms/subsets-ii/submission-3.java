class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        dfs(nums, 0);

        return result;
    }

    private void dfs(int[] nums, int idx) {
        if (idx >= n) {
            result.add(new ArrayList<>(path));
            return;
        }

        int num = nums[idx];
        path.add(num);
        dfs(nums, idx + 1);
        path.remove(path.size() - 1);

        while (idx + 1 < n && num == nums[idx + 1]) {
            idx++;
        }

        dfs(nums, idx + 1);
    }
}
