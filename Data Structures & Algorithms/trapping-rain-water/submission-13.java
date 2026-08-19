class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int[] prefixMaxHeight = new int[n], suffixMaxHeight = new int[n];
        prefixMaxHeight[0] = height[0];
        suffixMaxHeight[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            prefixMaxHeight[i] = Math.max(prefixMaxHeight[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixMaxHeight[i] = Math.max(suffixMaxHeight[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            int amt = Math.min(prefixMaxHeight[i], suffixMaxHeight[i]) - height[i];
            result += amt;
        }

        return result;        
    }
}
