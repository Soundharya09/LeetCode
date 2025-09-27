class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode a = fast;
        fast = fast.next;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode b = slow;
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
        return head;
    }
}