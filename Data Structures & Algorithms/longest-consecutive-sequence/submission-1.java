class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int len = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;

            map.put(num, map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0) + 1);
            map.put(num - map.getOrDefault(num - 1, 0), map.get(num));
            map.put(num + map.getOrDefault(num + 1, 0), map.get(num));
            len = Math.max(len, map.get(num));
        }

        return len;
    }
}
