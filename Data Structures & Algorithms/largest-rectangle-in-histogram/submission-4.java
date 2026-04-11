class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int idx = i;
            while (!stack.isEmpty() && height < stack.peek()[1]) {
                int[] bar = stack.pop();
                int w = i - bar[0];
                int h = bar[1];
                idx = bar[0];
                int area = w * h;
                result = Math.max(result, area);
            }
            stack.push(new int[] {idx, height});
        }

        while (!stack.isEmpty()) {
            int[] bar = stack.pop();
            int w = n - bar[0];
            int h = bar[1];
            int area = w * h;
            result = Math.max(result, area);
        }

        return result;
    }
}
