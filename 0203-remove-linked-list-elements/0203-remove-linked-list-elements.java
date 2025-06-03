class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //Iterative Approach
    //     ListNode res = new ListNode(0,head);
    //     ListNode temp = res;
    //     while(temp != null){
    //         while(temp.next != null && temp.next.val == val) {
    //             temp.next = temp.next.next;
    //         }
    //         temp = temp.next;
    //     }
    //     return res.next;
    // }

        //Recursive Approach
        if(head == null) return null;
        ListNode newList = removeElements(head.next, val);
        if(head.val == val) return newList;
        else head.next = newList;
        return head;
    }
}