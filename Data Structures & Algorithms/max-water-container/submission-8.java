class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0, r = n - 1;
        int result = 0;

        while (l < r) {
            int hL = heights[l], hR = heights[r];
            int area = Math.min(hL, hR) * (r - l);
            result = Math.max(result, area);

            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}
