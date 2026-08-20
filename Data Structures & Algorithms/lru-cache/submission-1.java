class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode left = new ListNode(-1, -1);
    ListNode right = new ListNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            remove(node);
        }

        node = new ListNode(key, value);
        map.put(key, node);
        insert(node);

        if (map.size() > capacity) {
            ListNode lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(ListNode node) {
        ListNode prev = right.prev, next = right;
        node.prev = prev;
        node.next = right;
        prev.next = node;
        next.prev = node;
    }
}


