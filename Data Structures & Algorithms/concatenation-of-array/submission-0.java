class Solution {
    public int[] getConcatenation(int[] nums) {
        int N = nums.length;
        int[] ans = new int[2 * N];
        for (int i = 0; i < ans.length; i++) {
            int j = i % N;
            ans[i] = nums[j];
        }

        return ans;
    }
}