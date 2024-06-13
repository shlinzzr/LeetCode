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
        ListNode odd = head;
        if(head==null)
            return null;
        
        ListNode dummy = new ListNode();
        
        ListNode even = head.next;
        if(even==null)
            return head;

        
        ListNode prev = null;
        while(odd!=null){
            
            ListNode next = odd.next;
            
            ListNode oddNext = (next==null)?null : next.next;
            odd.next = oddNext;
            prev = odd;
            odd = oddNext;
            
            dummy.next = next;
            dummy = dummy.next;
        }
        
        if(prev!=null)
            prev.next = even;
        
        return head;
    }
}