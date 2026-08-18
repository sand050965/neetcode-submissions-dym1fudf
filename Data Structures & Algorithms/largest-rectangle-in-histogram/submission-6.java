class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int start = i;
            while (!stack.isEmpty() && height < stack.peek()[0]) {
                int[] bar = stack.pop();
                start = bar[1];
                int area = bar[0] * (i - bar[1]);
                result = Math.max(result, area);
            }
            stack.push(new int[] {height, start});
        }

        while (!stack.isEmpty()) {
            int[] bar = stack.pop();
            int area = bar[0] * (n - bar[1]);
            result = Math.max(result, area);
        }

        return result;
    }
}
