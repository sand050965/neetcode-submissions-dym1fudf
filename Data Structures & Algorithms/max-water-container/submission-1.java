class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0, r = n - 1, result = 0;

        while (l < r) {
            int amount = (r - l) * Math.min(heights[l], heights[r]);
            result = Math.max(result, amount);
            if (heights[l] < heights[r])
                l++;
            else
                r--;
        }

        return result;
    }
}
