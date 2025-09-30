class Solution {
    public ListNode merge(ListNode list1, ListNode list2) {
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode mergedList = lists[0];
        for(int i = 1; i < lists.length; i++) {
            mergedList = merge(mergedList, lists[i]);
        }
        return mergedList;
    }
}