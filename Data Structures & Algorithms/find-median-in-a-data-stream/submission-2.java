class MedianFinder {
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    // even: maxHeap.size() == minHeap.size();
    // odd: maxHeap.size() + 1 == minHeap.size()

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        while (
            (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())
            || maxHeap.size() + 1 > minHeap.size()
        ) {
            minHeap.offer(maxHeap.poll());
        }

        while (maxHeap.size() + 1 < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return ((maxHeap.size() + minHeap.size()) % 2 == 0)
            ? ((double) maxHeap.peek() + minHeap.peek()) / 2
            : (double) minHeap.peek();
        
    }
}
