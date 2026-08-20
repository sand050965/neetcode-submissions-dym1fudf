class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Stack<Double> stack = new Stack<>();
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = n - 1; i >= 0; i--) {
            double time = ((double) target - cars[i][0]) / cars[i][1];
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }

            stack.push(time);
        }

        return stack.size();
    }
}
