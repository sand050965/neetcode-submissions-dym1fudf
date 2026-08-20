class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int maxLeft = height[l], maxRight = height[r];
        int result = 0;

        while (l < r) {
            if (maxLeft <= maxRight) {
                result += maxLeft - height[l++];
                maxLeft = Math.max(maxLeft, height[l]);
            } else {
                result += maxRight - height[r--];
                maxRight = Math.max(maxRight, height[r]);
            }
        }

        return result;
    }
}
