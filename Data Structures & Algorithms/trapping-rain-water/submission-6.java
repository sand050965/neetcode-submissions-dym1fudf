class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int l = 0, r = n - 1;
        int maxLeft = height[0], maxRight = height[n - 1];

        while (l < r) {
            if (maxLeft <= maxRight) {
                result += maxLeft - height[l];
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
            } else {
                result += maxRight - height[r];
                r--;
                maxRight = Math.max(maxRight, height[r]);
            }
        }

        return result;
    }
}
