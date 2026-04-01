class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gasSum = 0, costSum = 0;

        for (int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) {
            return -1;
        }

        int balance = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (balance < 0) {
                balance = 0;
                result = i;
            }

            balance += (gas[i] - cost[i]);
        }

        return result;
    }
}
