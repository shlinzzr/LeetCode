// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;

        while(n-->=0){
            fast = fast.next;
        }

        ListNode slow = dummy;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }


        if(slow!=null)
            slow.next = slow.next.next;


        return dummy.next;

    }
}