class Solution {
    public int lastStoneWeight(int[] stones) {
        int max = Arrays.stream(stones).max().getAsInt();
        int[] bucket = new int[max + 1];
        for (int stone : stones) {
            bucket[stone]++;
        }

        int first = max, second = first - 1;

        while (first > 0) {
            while (first > 0 && bucket[first] == 0) {
                first--;
            }

            bucket[first] %= 2;

            if (first == 0) {
                return first;
            }

            if (bucket[first] == 0) {
                continue;
            }

            second = first - 1;

            while (second > 0 && bucket[second] == 0) {
                second--;
            }

            if (second == 0) {
                return first;
            }

            bucket[first]--;
            bucket[second]--;
            bucket[first - second]++;
            first = Math.max(first - 1, first - second);
        }

        return first;
    }
}
