class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];
        double[] time = new double[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {position[i], speed[i]};
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            time[i] = (double) ((target - pairs[i][0])) / pairs[i][1];
        }

        double prevTime = time[0];
        int result = 1;

        for (int i = 1; i < n; i++) {
            double t = time[i];
            if (t > prevTime) {
                result++;
                prevTime = t;
            }
        }

        return result;
    }
}
