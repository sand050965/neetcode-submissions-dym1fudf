class Node {
    int key, val;
    Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = this.next = null;
    }
}

class LRUCache {
    int capacity;
    Node head, tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.map = new HashMap<>();

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        add(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == this.capacity) {
            removeLRU();
        }

        Node node = new Node(key, value);
        add(node);
    }

    private void add(Node node) {
        Node prev = this.head, next = prev.next;
        node.prev = prev;
        node.next = next;
        prev.next = next.prev = node;

        map.put(node.key, node);
    }

    private void remove(Node node) {
        Node prev = node.prev, next = node.next;
        node.prev = node.next = null;
        prev.next = next;
        next.prev = prev;

        map.remove(node.key);
    }

    private void removeLRU() {
        Node lru = this.tail.prev;

        if (lru == this.head) {
            return;
        }

        remove(lru);
    }
}
