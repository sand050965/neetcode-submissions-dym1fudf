class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones)
            maxHeap.offer(stone);

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone2 < stone1)
                maxHeap.offer(stone1 - stone2);
        }

        return (maxHeap.size() == 0) ? 0 : maxHeap.peek();
    }
}
