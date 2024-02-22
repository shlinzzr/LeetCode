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
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        
        
        while(curr.next!=null){
            if(curr.next.val==val){
                curr.next = curr.next.next;
                
            }else{
                curr = curr.next;
            }
        }
        
        return dummy.next;
       
//        if(head.val==val){
//           head = head.next;        
//        } 
                
//        if(head.next==null)
//            return head;
        
//        ListNode cp = new ListNode(head.val, head.next);
        
//        while(head.next!=null){
           
           
           
           
//            head = head.next;
           
//        }
        
        
        
//        if(head.next.val!=val){
//            removeElements(head.next, val);
//        }
        
        
    }
}