class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }

            map.put(num, 1 + map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0));
            map.put(num + map.getOrDefault(num + 1, 0), map.get(num));
            map.put(num - map.getOrDefault(num - 1, 0), map.get(num));
            result = Math.max(result, map.get(num));
        }

        return result;
    }
}
