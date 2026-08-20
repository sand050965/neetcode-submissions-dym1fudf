class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> permutation = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        dfs(nums);

        return result;
    }

    private void dfs(int[] nums) {
        if (permutation.size() == n) {
            result.add(new ArrayList<>(permutation));
        }

        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            
            permutation.add(num);
            set.add(num);
            dfs(nums);
            permutation.remove(permutation.size() - 1);
            set.remove(num);
        }
    }
}
