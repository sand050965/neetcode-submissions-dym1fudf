class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);

        return result;
    }

    private void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }

            set.add(i);
            path.add(nums[i]);
            backtrack(nums);
            set.remove(i);
            path.removeLast();
        }
    }
}
