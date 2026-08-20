class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int h : hand) {
            if (!freq.containsKey(h)) {
                minHeap.offer(h);
            }

            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        while (!minHeap.isEmpty()) {
            int min = minHeap.peek();
            
            for (int i = min; i < min + groupSize; i++) {
                if (!freq.containsKey(i)) {
                    return false;
                }

                freq.put(i, freq.get(i) - 1);

                if (freq.get(i) == 0) {
                    freq.remove(i);

                    if (i != minHeap.peek()) {
                        return false;
                    }

                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
