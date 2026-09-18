class Solution {
    int n;
    List<Integer> combination = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        n = nums.length;

        recurse(nums, target, 0);

        return result;
    }

    private void recurse(int[] nums, int target, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }


        for (int i = idx; i < n; i++) {
            int num = nums[i];
            if (target - num < 0) {
                continue;
            }
            
            combination.add(num);
            recurse(nums, target - num, i);
            combination.removeLast();
        }
    }
}
