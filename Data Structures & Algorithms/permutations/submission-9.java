class Solution {
    int n;
    List<Integer> permutation = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        recurse(nums);

        return result;
    }

    private void recurse(int[] nums) {
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
            recurse(nums);
            permutation.removeLast();
            set.remove(num);
        }
    }
}
