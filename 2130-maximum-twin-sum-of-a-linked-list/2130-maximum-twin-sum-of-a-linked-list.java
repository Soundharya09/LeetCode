/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        int maxSum = 0;
        ListNode first = head, second = secondHalf;
        while (second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode a = head.next;
        ListNode newHead = reverse(a);
        a.next = head;
        head.next = null;
        return newHead;
    }
}