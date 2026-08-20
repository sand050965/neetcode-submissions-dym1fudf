class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
                int barIdx = stack.pop();
                int height = heights[barIdx];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, height * width);
            }

            stack.push(i);
        }

        return result;
    }
}
