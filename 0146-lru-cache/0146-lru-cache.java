class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);  
        this.tail = new Node(0, 0); 
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        // Case 1: Key already exists → update value & move to front
        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }
        // Case 2: New key → create new node
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);
        
        // Case 3: Over capacity → remove LRU
        if (map.size() > capacity) {
            Node lru = tail.prev;        
            removeNode(lru);
            map.remove(lru.key);
        }
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */