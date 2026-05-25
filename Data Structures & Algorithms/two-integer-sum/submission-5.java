class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return new int[] {map.get(num), i};
            }

            int diff = target - num;
            map.put(diff, i);
        }

        return new int[0];
    }
}
