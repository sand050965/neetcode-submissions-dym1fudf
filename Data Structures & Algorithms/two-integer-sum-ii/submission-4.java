class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[2];
        }
        int n = numbers.length;
        int l = 0, r = n - 1;
        Arrays.sort(numbers);
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] {l + 1, r + 1};
            }

            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[2];
    }
}
