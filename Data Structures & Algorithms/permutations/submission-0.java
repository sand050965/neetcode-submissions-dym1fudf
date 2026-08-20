class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, boolean[] chosen) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (chosen[i]) continue;
            path.add(nums[i]);
            chosen[i] = true;
            backtrack(nums, chosen);
            path.remove(path.size() - 1);
            chosen[i] = false;
        }
    }
}
