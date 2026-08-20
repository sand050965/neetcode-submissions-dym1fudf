class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length, maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int idx = i;

            while (!stack.isEmpty() && height < stack.peek()[1]) {
                int[] prev = stack.pop();
                idx = prev[0];
                maxArea = Math.max(maxArea, prev[1] * (i - prev[0]));
            }

            stack.push(new int[] { idx, height });
        }

        while (!stack.isEmpty()) {
            int[] bar = stack.pop();
            maxArea = Math.max(maxArea, bar[1] * (n - bar[0]));
        }

        return maxArea;
    }
}
