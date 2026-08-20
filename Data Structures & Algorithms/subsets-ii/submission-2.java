class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        backtrack(nums, 0);

        return result;
    }

    private void backtrack(int[] nums, int idx) {
        if (idx >= n) {
            result.add(new ArrayList<>(subset));
            return;
        }

        int num = nums[idx];
        subset.add(num);
        backtrack(nums, idx + 1);
        subset.remove(subset.size() - 1);

        while (idx + 1 < n && num == nums[idx + 1]) {
            idx++;
        }

        backtrack(nums, idx + 1);
    }
}
