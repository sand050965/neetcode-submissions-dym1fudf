class Node {
    int val, key;
    Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
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
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
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
            map.remove(key);
        }

        if (map.size() == this.capacity) {
            Node lru = this.tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);
        add(node);
        map.put(key, node);
    }

    private void add(Node node) {
        Node prev = this.head, next = this.head.next;
        node.prev = prev;
        node.next = next;
        prev.next = next.prev = node;
    }

    private void remove(Node node) {
        if (node == this.head) {
            return;
        }

        Node prev = node.prev, next = node.next;
        node.prev = node.next = null;
        prev.next = next;
        next.prev = prev;
    }
}
