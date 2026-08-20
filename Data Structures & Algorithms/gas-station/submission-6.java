class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;

        int n = gas.length, start = n - 1, end = 0;
        int tank = gas[start] - cost[start];

        while (start > end) {
            if (tank < 0) {
                start--;
                tank += gas[start] - cost[start];
            } else {
                tank += gas[end] - cost[end];
                end++;
            }
        }

        return tank >= 0 ? start : -1;
    }
}
