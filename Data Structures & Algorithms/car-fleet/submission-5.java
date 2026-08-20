class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0 || speed == null || speed.length == 0)
            return 0;

        int n = position.length;
        int[][] cars = new int[n][2];
        int fleet = 0;
        double prevTime = 0;

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] car : cars) {
            int p = car[0];
            int s = car[1];
            double currentTime = (double) (target - p) / s;

            if (prevTime < currentTime) {
                fleet++;
                prevTime = currentTime;
            }
        }

        return fleet;
    }
}
