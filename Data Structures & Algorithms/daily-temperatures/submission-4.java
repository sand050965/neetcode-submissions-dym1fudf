class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[0];

        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;

            while (i < n && temperatures[j] <= temperatures[i]) {
                if (result[j] == 0) {
                    j = n;
                    break;
                }
                
                j += result[j];
            }

            if (j < n) {
                result[i] = j - i;
            }
        }

        return result;
    }
}
