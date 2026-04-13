class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int h = hand[i];
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            minHeap.offer(key);
        }

        while (!minHeap.isEmpty()) {
            int min = minHeap.peek();
            for (int i = min; i < min + groupSize; i++) {
                if (!map.containsKey(i) || map.get(i) == 0) {
                    return false;
                }

                map.put(i, map.get(i) - 1);

                if (map.get(i) == 0) {
                    if (minHeap.peek() != i) {
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
