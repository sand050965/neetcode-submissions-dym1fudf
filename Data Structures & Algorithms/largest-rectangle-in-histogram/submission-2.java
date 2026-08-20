class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int startIdx = i;
            int height = heights[i];

            while (!stack.isEmpty() && height < stack.peek()[1]) {
                int[] bar = stack.pop();
                int idx = bar[0];
                int h = bar[1];
                int area = h * (i - idx);
                result = Math.max(result, area);
                startIdx = idx;
            }

            stack.push(new int[] {startIdx, height});
        }

        while (!stack.isEmpty()) {
            int[] bar = stack.pop();
            int idx = bar[0];
            int h = bar[1];
            int area = h * (n - idx);
            result = Math.max(result, area);
        }

        return result;
    }
}
