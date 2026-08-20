class Solution {
    public int trap(int[] height) {
        int n = height.length, result = 0;
        
        if (n == 0)
            return 0;
            
        int leftMax = height[0], rightMax = height[n - 1];
        int l = 0, r = n - 1;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                result += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                result += rightMax - height[r];
            }
        }

        return result;
    }
}
