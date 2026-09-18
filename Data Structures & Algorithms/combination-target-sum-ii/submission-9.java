class Solution {
    int n;
    List<Integer> combination = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        Arrays.sort(candidates);
        recurse(candidates, target, 0);

        return result;
    }

    private void recurse(int[] candidates, int target, int idx) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int candidate = candidates[i];
            combination.add(candidate);
            recurse(candidates, target - candidate, i + 1);
            combination.removeLast();
        }
    }
}
