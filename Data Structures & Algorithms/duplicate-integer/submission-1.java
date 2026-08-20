class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            Integer freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer freq = entry.getValue();
            if (freq > 1) {
                return true;
            }
        }

        return false;
    }
}