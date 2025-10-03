class Solution {
    public ListNode reverseList(ListNode head) {
        //Method - 1 -> Iterative Approach
        // ListNode curr = head;
        // ListNode prev = null, Next = null;
        // while(curr != null) {
        //     Next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = Next;
        // }
        // return prev;
        
        //Method - 2 -> Recursive Approach
        if(head == null || head.next == null) return head;
        ListNode a = head.next;
        ListNode newHead = reverseList(a);
        a.next = head;
        head.next = null;
        return newHead;
    }
}