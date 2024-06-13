// https://leetcode.com/problems/remove-linked-list-elements

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
    public ListNode removeElements(ListNode head, int val) {
        
        if(head==null)
            return null;
        
         if(head.val == val)
             return head.next;
        
        ListNode curr = head;
        
        ListNode prev=null;
        while(curr!=null){
            
            if(curr.val==val){
                prev.next = curr.next;
            }
            prev = curr;
            curr=curr.next;            
        }
        
        return head;
    }
}