class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int l = 0, r = n - 1;
        int result = 0;
        int prefixMax = height[l], suffixMax = height[r];
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
                prefixMax = Math.max(prefixMax, height[l]);
                result += prefixMax - height[l];
            } else {
                r--;
                suffixMax = Math.max(suffixMax, height[r]);
                result += suffixMax - height[r];
            }
        }

        return result;
    }
}
