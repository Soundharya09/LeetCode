class AllOne {
    private class Node {
        int count;
        Set<String> keys;
        Node prev;
        Node next;
        
        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }
    private Map<String, Node> keyNodeMap;
    private Node head;
    private Node tail;

    public AllOne() {
        keyNodeMap = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    private Node addNodeAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        return newNode;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void inc(String key) {
        if (!keyNodeMap.containsKey(key)) {
            if (head.next.count == 1) {
                head.next.keys.add(key);
                keyNodeMap.put(key, head.next);
            } 
            else {
                Node newNode = addNodeAfter(head, 1);
                newNode.keys.add(key);
                keyNodeMap.put(key, newNode);
            }
        } 
        else {
            Node currNode = keyNodeMap.get(key);
            int newCount = currNode.count + 1;
            Node nextNode;
            if (currNode.next.count == newCount) nextNode = currNode.next;
            else nextNode = addNodeAfter(currNode, newCount);
            nextNode.keys.add(key);
            keyNodeMap.put(key, nextNode);
            
            currNode.keys.remove(key);
            if (currNode.keys.isEmpty()) removeNode(currNode);
        }
    }
    
    public void dec(String key) {
        Node currNode = keyNodeMap.get(key);
        int newCount = currNode.count - 1;
        
        if (newCount == 0) keyNodeMap.remove(key);
        else {
            Node prevNode;
            if (currNode.prev.count == newCount) prevNode = currNode.prev;
            else prevNode = addNodeAfter(currNode.prev, newCount);
            prevNode.keys.add(key);
            keyNodeMap.put(key, prevNode);
        }
        currNode.keys.remove(key);
        if (currNode.keys.isEmpty()) removeNode(currNode);
    }
    
    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */