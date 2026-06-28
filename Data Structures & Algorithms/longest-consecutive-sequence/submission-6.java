class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }

            int len = 1;
            while (set.contains(num + len)) {
                len++;
            }

            result = Math.max(result, len);
        }

        return result;
    }
}
