class KthLargest {
    Queue<Integer> minHeap;
    int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > size) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
