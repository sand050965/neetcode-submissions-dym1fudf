class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);

        return result;
    }

    private void backtrack(int[] candidates, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int candidate = candidates[i];
            if (target < candidate) {
                return;
            }

            path.add(candidate);
            backtrack(candidates, target - candidate, i + 1);
            path.removeLast();
        }
    }
}
