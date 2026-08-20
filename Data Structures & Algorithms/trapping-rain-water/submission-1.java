class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n], maxRight = new int[n];

        int max = 0, maxAmt = 0;
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i + 1], maxRight[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            int amt = Math.min(maxLeft[i], maxRight[i]) - height[i];
            maxAmt += (amt <= 0) ? 0 : amt;
        }

        return maxAmt;
    }
}
