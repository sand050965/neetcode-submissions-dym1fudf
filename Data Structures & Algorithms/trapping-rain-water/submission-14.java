class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int result = 0;
        int leftMax = height[0], rightMax = height[n - 1];


        while (l < r) {
            if (leftMax < rightMax) {
                result += (leftMax - height[l]);
                l++;
                leftMax = Math.max(leftMax, height[l]);
            } else {
                result += (rightMax - height[r]);
                r--;
                rightMax = Math.max(rightMax, height[r]);
            }
        }

        return result;
    }
}
