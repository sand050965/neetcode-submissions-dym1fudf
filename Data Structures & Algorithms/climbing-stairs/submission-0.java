class Solution {
    public int climbStairs(int n) {
        int[] mem = new int[n + 1];
        mem[n] = 1;
        mem[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            mem[i] = mem[i + 1] + mem[i + 2];
        }

        return mem[0];
    }
}
