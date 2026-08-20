class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        
        if (nums == null || n == 0)
            return false;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                return true;
            
            set.add(num);
        }

        return false;
    }
}