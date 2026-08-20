class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> stack = new Stack<>();
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] pair : pairs) {
            stack.push((double) (target - pair[0]) / pair[1]);
            int size = stack.size();

            if (size >= 2 && stack.peek() <= stack.get(size - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }
}
