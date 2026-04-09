class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        prev = next = null;
    }
}

class LRUCache {
    int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        cache = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        ListNode node = cache.get(key);
        remove(node);
        add(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key) && cache.size() == capacity) {
            ListNode lruNode = head.next;
            remove(lruNode);
            cache.remove(lruNode.key);
        }

        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        ListNode node = new ListNode(key, value);
        cache.put(key, node);
        add(node);
    }

    private void add(ListNode node) {
        ListNode prev = tail.prev;
        ListNode next = tail;
        
        node.prev = prev;
        node.next = next;

        prev.next = node;
        next.prev = node;
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = node.next = null;
    }
}
