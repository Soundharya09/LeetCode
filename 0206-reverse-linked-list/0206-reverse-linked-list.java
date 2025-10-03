class Solution {
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
}