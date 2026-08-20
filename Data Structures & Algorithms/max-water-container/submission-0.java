class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxAmt = 0;
        while (left < right) {
            int amt = (right - left) * Math.min(heights[left], heights[right]);
            maxAmt = Math.max(maxAmt, amt);

            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return maxAmt;
    }
}
