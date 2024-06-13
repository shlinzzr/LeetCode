// https://leetcode.com/problems/odd-even-linked-list

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
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode curr = even.next;

        // ListNode prev = null;
        while(curr!=null){
            odd.next = curr;
            odd = odd.next;
            curr = curr.next;

            if(curr!=null){
                even.next = curr;
                even=even.next;
                curr=curr.next;
            }
        }
        
        // even.next= null;
        odd.next = evenHead;
        return head;

    }
}