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

        if (idx >= candidates.length || target < 0) {
            return;
        }

        int candidate = candidates[idx];
        path.add(candidate);
        backtrack(candidates, target - candidate, idx + 1);
        path.removeLast();

        while (idx < candidates.length - 1 && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }

        backtrack(candidates, target, idx + 1);
    }
}
