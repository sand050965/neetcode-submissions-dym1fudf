class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        
        return result;
    }

    private void backtrack(int[] candidates, int target, int idx, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }


        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            
            path.add(candidates[i]);
            backtrack(candidates, target, i + 1, sum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
