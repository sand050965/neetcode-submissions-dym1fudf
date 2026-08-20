class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < temperature) {
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }

            stack.push(new int[]{temperature, i});
        }

        return result;
    }
}
