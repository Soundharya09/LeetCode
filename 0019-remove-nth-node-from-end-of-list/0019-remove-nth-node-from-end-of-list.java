class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        //move fast 'n' steps ahead
        for(int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        //edge case
        if(fast == null) return head.next;
        //move slow n fast together till fast reaches tail
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}