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
        ListNode list = new ListNode(0);
        ListNode curr = list;
        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            }
            else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 != null) ? list1 : list2;
        return list.next;
    }
}