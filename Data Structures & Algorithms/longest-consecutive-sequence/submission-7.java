class Solution {
    public int longestConsecutive(int[] nums) {
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
