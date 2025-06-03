class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0,head);
        ListNode temp = res;
        while(temp != null){
            while(temp.next != null && temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return res.next;
    }
}