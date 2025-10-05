class Solution {
    public Node deepCopy(Node head) {
        Node head2 = new Node(head.val);
        Node t1 = head.next;
        Node t2 = head2;
        while(t1 != null) {
            Node temp = new Node(t1.val);
            t2.next = temp;
            t2 = t2.next;
            t1 = t1.next;
        }
        return head2;
    }
    public void connectAlternative(Node head, Node head2) {
        Node t1 = head;
        Node t2 = head2;
        Node dummy = new Node(-1);
        Node t = dummy;
        while(t1 != null && t2 != null) {
            t.next = t1;
            t1 = t1.next;
            t = t.next;
            t.next = t2;
            t2 = t2.next;
            t = t.next;
        }
    }
    public void assignRandom(Node head, Node head2) {
        Node t1 = head;
        Node t2 = head2;
        while(t1 != null) {
            t2 = t1.next;
            if(t1.random != null) t2.random = t1.random.next;
            t1 = t1.next.next;
        }
    }
    public void split(Node head, Node head2) {
        Node t1 = head;
        Node t2 = head2;
        while(t1 != null) {
            t1.next = t2.next;
            t1 = t1.next;
            if(t1 == null) break;
            t2.next = t1.next;
            t2 = t2.next;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        //Step 1 -> create deep copy w/o random connections
        Node head2 = deepCopy(head);
        //Step 2 -> connect linked list alternatively
        connectAlternative(head,head2);
        //Step 3 -> assign random pointers
        assignRandom(head,head2);
        //Step 4 -> split linked list again
        split(head,head2);
        return head2;
    }
}