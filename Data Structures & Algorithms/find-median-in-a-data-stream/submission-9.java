class MedianFinder {
    Queue<Integer> maxHeap, minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if ((maxHeap.size() > minHeap.size() + 1) || (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())) {
            minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return (maxHeap.size() > minHeap.size()) ? maxHeap.peek() : minHeap.peek();
    }
}
