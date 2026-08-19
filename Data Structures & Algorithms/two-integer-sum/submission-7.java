class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int diff = target - num;

            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }

            map.put(num, i);
        }

        return new int[2];
    }
}
