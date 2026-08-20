class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        int max = Integer.MIN_VALUE;
        for (int stone : stones) {
            max = Math.max(max, stone);
        }
        int[] bucket = new int[max + 1]; 

        for (int stone : stones) {
            bucket[stone]++;
        }
        
        int stone1 = max, stone2 = max;
        while (stone1 > 0) {
            if (bucket[stone1] % 2 == 0) {
                bucket[stone1] = 0;
                stone1--;
                continue;
            }

            stone2 = Math.min(stone1 - 1, stone2);
            while (stone2 > 0 && bucket[stone2] == 0) {
                stone2--;
            }

            if (stone2 == 0) {
                return stone1;
            }

            bucket[stone1]--;
            bucket[stone2]--;
            bucket[stone1 - stone2]++;
            stone1 = Math.max(stone1 - stone2, stone2);
        }

        return stone1;
    }
}
