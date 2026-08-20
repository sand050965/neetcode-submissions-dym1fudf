class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int num: nums) {
            Set<Integer> copy = new HashSet<>(dp);
            for (int i: dp) {
                if (i + num == target) 
                    return true;

                copy.add(i + num);
            }
            dp = copy;
        }

        return false;
    }
}
