class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);

        return result;
    }

    private void backtrack(int[] candidates, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < n; i++) {
            int candidate = candidates[i];

            if (candidate > target) {
                return;
            }

            if (i > idx && candidate == candidates[i - 1]) {
                continue;
            }

            path.add(candidate);
            backtrack(candidates, target - candidate, i + 1);
            path.remove(path.size() - 1);
        }
    } 
}
