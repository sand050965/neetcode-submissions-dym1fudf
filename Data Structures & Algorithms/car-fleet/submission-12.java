class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        double[] time = new double[n];
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            cars[i] = new int[] {position[i], speed[i]};
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            time[i] = (double) ((target - cars[i][0])) / (double) cars[i][1];
        }

        for (double t : time) {
            if (!stack.isEmpty() && t <= stack.peek()) {
                continue;
            }

            stack.push(t);
        }

        return stack.size();
    }
}
