class Solution {
    public ListNode middleNode(ListNode head) {
        //if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        //Method - 1 -> Iterative Approach
        ListNode curr = head;
        ListNode prev = null, Next = null;
        while(curr != null) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode leftMid = middleNode(head);
        ListNode h2 = leftMid.next;
        leftMid.next = null;
        h2 = reverseList(h2);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head != null && h2 != null) {
            temp.next = head;
            head = head.next;
            temp = temp.next;
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;
        }
        if(head == null) temp.next = h2;
        if(h2 == null) temp.next = head;
        head = dummy.next;
    }
}