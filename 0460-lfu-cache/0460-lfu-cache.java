class LFUCache {
    private final int capacity;
    private final Map<Integer, Node> keyToNode;
    private final Map<Integer, DoublyLinkedList> freqToList;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
        this.minFreq = 0;
    }
    
    public int get(int key) {
        Node node = keyToNode.get(key);
        if (node == null) return -1;
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = keyToNode.get(key);
        if (node != null) {
            node.value = value;
            updateFrequency(node);
            return;
        }
        if (keyToNode.size() == capacity) evict();
        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        freqToList.computeIfAbsent(1, k -> new DoublyLinkedList()).addLast(newNode);
        minFreq = 1;
    }

    public void updateFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqToList.get(oldFreq);
        oldList.remove(node);
        if (oldFreq == minFreq && oldList.isEmpty()) minFreq++;
        node.freq++;
        DoublyLinkedList newList = freqToList.computeIfAbsent(node.freq, k -> new DoublyLinkedList());
        newList.addLast(node);
    }

    private void evict() {
        DoublyLinkedList list = freqToList.get(minFreq);
        Node toRemove = list.removeFirst();
        keyToNode.remove(toRemove.key);
        if (list.isEmpty()) freqToList.remove(minFreq);
    }

    private static class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private static class DoublyLinkedList {
        private final Node head;
        private final Node tail;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        void addLast(Node node) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }

        void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
        }

        Node removeFirst() {
            if (isEmpty()) return null;
            Node node = head.next;
            remove(node);
            return node;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */