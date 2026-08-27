class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int a = maxHeap.poll(), b = maxHeap.poll();

            if (a == b) {
                continue;
            }

            maxHeap.offer(Math.abs(a - b));
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
