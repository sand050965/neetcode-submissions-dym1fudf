class ListNode {
    int key;
    int value;
    ListNode prev = null;
    ListNode next = null;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> cache;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        ListNode node = cache.get(key);
        remove(node);
        insert(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        ListNode node = new ListNode(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > capacity) {
            ListNode lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void insert(ListNode node) {
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
