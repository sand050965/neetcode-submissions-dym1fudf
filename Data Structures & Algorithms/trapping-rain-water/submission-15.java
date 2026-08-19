class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int l = 0, r = n - 1;
        int leftMax = height[l], rightMax = height[r];

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                result += (leftMax - height[l]);
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                result += (rightMax - height[r]);
            }
        }

        return result;
    }
}
