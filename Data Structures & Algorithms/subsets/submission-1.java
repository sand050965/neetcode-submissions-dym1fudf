class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);

        return result;
    }

    private void backtrack(int[] nums, int idx) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[idx]);
        backtrack(nums, idx + 1);
        path.remove(path.size() - 1);
        
        backtrack(nums, idx + 1);
    }
}
