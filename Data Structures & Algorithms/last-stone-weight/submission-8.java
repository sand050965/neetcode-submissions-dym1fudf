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

            if (bucket[first] % 2 == 0) {
                first--;
                continue;
            }

            second = Math.min(first - 1, second);
            
            while (second > 0 && bucket[second] == 0) {
                second--;
            }

            if (second == 0) {
                return first;
            }

            bucket[first]--;
            bucket[second]--;
            bucket[first - second]++;
            first = Math.max(first, first - second);
        }

        return 0;
    }
}
