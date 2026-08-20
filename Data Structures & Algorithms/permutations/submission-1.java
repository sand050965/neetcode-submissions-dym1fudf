class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> permutation =  new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        backtrack(nums);

        return result;
    }

    private void backtrack(int[] nums) {
        if (permutation.size() == n) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                continue;
            }

            permutation.add(num);
            set.add(num);
            backtrack(nums);
            permutation.remove(permutation.size() - 1);
            set.remove(num);
        }
    }
}
