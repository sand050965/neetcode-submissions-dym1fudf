class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return new int[0];

        int n = numbers.length;
        int l = 0, r = n - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[] {l + 1, r + 1};
            }
        }

        return new int[0];
    }
}
