class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int gasTotal = 0;
        int result = 0;

        for (int i = 0; i < n - 1; i++) {
            gasTotal += gas[i] - cost[i];

            if (gasTotal < 0) {
                gasTotal = 0;
                result = i + 1;
            }
        }

        return result;
    }
}
