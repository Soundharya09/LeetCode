class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> delete = new HashSet<>();
        for(int i : nums) delete.add(i);
        ListNode curr = head;
        while(curr != null && delete.contains(curr.val)) {
            curr = curr.next;
        }
        head = curr;
        if(curr == null) return null;
        ListNode prev = curr;
        curr = curr.next;
        while(curr != null) {
            if(delete.contains(curr.val)) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return head;
    }
}