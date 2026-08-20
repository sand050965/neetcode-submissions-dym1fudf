class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length, result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        
        for (int num : set) {
            int length = 1;
            if (set.contains(num - 1))
                continue;
            
            while (set.contains(num + length)) {
                length++;
            }
            
            result = Math.max(result, length);
        }

        return result;
    }
}
