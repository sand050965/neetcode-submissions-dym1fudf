class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int result = heights[0];

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int idx = i;
            while (!stack.isEmpty() && height < stack.peek()[0]) {
                int[] prev = stack.pop();
                int prevHeight = prev[0];
                int prevIdx = prev[1];
                int area = prevHeight * (i - prevIdx);
                idx = prevIdx;
                result = Math.max(result, area);
            }

            stack.push(new int[] {height, idx});
        }

        while (!stack.isEmpty()) {
            int[] bar = stack.pop();
            int height = bar[0];
            int idx = bar[1];
            int area = height * (n - idx);
            result = Math.max(result, area);
        }

        return result;
    }
}
