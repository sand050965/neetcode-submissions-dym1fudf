class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;
        
        int n = gas.length, result = 0, total = 0;

        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            
            if (total < 0) {
                total = 0;
                result = i + 1;
            }
        }

        return result;
    }
}
