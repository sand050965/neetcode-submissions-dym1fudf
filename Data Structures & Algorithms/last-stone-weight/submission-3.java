class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 == stone2) {
                continue;
            }
            
            if (stone1 > stone2) {
                maxHeap.offer(stone1 - stone2);
            } else {
                maxHeap.offer(stone2 - stone1);
            }
        }

        return (maxHeap.size() == 0) ? 0 : maxHeap.peek();
    }
}
