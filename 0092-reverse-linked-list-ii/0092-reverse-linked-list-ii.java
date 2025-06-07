class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode current = start.next;
        for(int i = 0; i < right - left; i++) {
            start.next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = start.next;
        }
        return dummy.next;
    }
}