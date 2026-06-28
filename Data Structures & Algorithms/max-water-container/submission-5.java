class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int n = heights.length;
        int l = 0, r = n - 1;

        while (l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            result = Math.max(result, area);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}
