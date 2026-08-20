class LRUCache {
    class Node {
        int key, val;
        Node prev, next;

        public Node() {
            prev = next = null;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node left, right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        left = new Node();
        right = new Node();
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);

        if (map.size() > capacity) {
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = node.next = null;
    }

    private void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        right.prev = node;
        node.prev = prev;
        node.next = right;
    }
}
