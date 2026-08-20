class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num))
                return new int[] {map.get(num), i};

            map.put(target - num, i);
        }

        return new int[] {};
    }
}
