class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Recursive Approach
        // if(list1 == null) return list2;
        // if(list2 == null) return list1;
        // if(list1.val < list2.val) {
        //     list1.next = mergeTwoLists(list1.next, list2);
        //     return list1;
        // } else {
        //     list2.next = mergeTwoLists(list1, list2.next);
        //     return list2;
        // }

        //Iterative Approach
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 == null) temp.next = temp2;
        else temp.next = temp1;
        return dummy.next;
    }
}