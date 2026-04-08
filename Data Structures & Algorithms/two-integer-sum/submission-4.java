class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int remainder = target - num;
            if (map.containsKey(remainder)) {
                return new int[] {map.get(remainder), i};
            }

            map.put(num, i);
        }

        return new int[2];
    }
}
