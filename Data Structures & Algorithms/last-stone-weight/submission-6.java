class Solution {
    public int lastStoneWeight(int[] stones) {
        int max = Arrays.stream(stones).max().getAsInt();
        int[] bucket = new int[max + 1];
        for (int stone : stones) {
            bucket[stone]++;
        }

        int first = max, second = max;
        while (first > 0) {
            if (bucket[first] % 2 == 0) {
                first--;
                continue;
            }

            int j = Math.min(first - 1, second);
            while (j > 0 && bucket[j] == 0) {
                j--;
            }

            if (j == 0) {
                return first;
            }

            second = j;
            bucket[first]--;
            bucket[second]--;
            bucket[first - second]++;
            first = Math.max(first - second, second);
        }

        return first;
    }
}
