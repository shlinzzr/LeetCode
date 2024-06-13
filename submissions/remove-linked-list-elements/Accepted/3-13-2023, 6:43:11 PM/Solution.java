// https://leetcode.com/problems/remove-linked-list-elements

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}