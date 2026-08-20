class MedianFinder {
    Queue<Integer> leftMaxHeap;
    Queue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        leftMaxHeap.offer(num);
        balance();
    }
    
    public double findMedian() {
        int size = leftMaxHeap.size() + rightMinHeap.size();

        if (size % 2 == 0) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
        
        return (leftMaxHeap.size() > rightMinHeap.size()) ?
            leftMaxHeap.peek() :
            rightMinHeap.peek();
    }

    private void balance() {
        if (
            (!rightMinHeap.isEmpty() && leftMaxHeap.peek() > rightMinHeap.peek()) ||
            (leftMaxHeap.size() - rightMinHeap.size() > 1)
         ) {
            rightMinHeap.offer(leftMaxHeap.poll());
        }

        if (rightMinHeap.size() - leftMaxHeap.size() > 1) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }
}
