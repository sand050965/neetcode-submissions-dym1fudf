class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }

            int next = num + 1;
            while (set.contains(next)) {
                result = Math.max(result, next - num + 1);
                next++;
            }
        }

        return result;
    }
}
