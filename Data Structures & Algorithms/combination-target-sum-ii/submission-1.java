class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        Arrays.sort(candidates);

        backtrack(candidates, target, 0);

        return result;
    }

    private void backtrack(int[] candidates, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0 || idx >= n) {
            return;
        }

        int candidate = candidates[idx];
        
        combination.add(candidate);
        backtrack(candidates, target - candidate, idx + 1);
        combination.remove(combination.size() - 1);

        while (idx + 1 < n && candidate == candidates[idx + 1]) {
            idx++;
        }
        
        backtrack(candidates, target, idx + 1);
    }
}
