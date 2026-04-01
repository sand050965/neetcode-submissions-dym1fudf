class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int h : hand) {
            if (!map.containsKey(h)) {
                minHeap.offer(h);
            }

            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        while (!minHeap.isEmpty()) {
            int min = minHeap.peek();
            for (int i = min; i < min + groupSize; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }

                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    if (i != minHeap.peek()) {
                        return false;
                    }

                    map.remove(i);
                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
