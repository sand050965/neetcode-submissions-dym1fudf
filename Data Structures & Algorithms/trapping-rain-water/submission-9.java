class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int result = 0;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }

        suffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        while (l < r) {
            if (prefix[l] <= suffix[r]) {
                result += prefix[l] - height[l];
                l++;
            } else {
                result += suffix[r] - height[r];
                r--;
            }
        }

        return result;
    }
}
