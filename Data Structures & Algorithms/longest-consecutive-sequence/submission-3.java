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

            int nextNum = num;
            while (set.contains(nextNum)) {
                nextNum++;
            }

            result = Math.max(result, nextNum - num); 
        }

        return result;
    }
}
