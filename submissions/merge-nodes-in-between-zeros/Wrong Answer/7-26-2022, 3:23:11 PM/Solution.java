// https://leetcode.com/problems/merge-nodes-in-between-zeros

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
    public ListNode mergeNodes(ListNode head) {

        ListNode curr = head;
        //     while(head.next!=null){
        //     System.out.println("->" + head.val);
        //     head = head.next;
        // }
        
        ListNode cutTail = head;
        
        while(curr!=null){
            
         
            moveHead(curr);
            appendVal(curr);
            cutTail = curr;
            curr = curr.next;
            
        }
        
        cutTail.next = null;
        
        // // cut tail
        // curr = head;
        // while(curr!=null &&curr.next!=null){
        //     if(curr.next.val==0)
        //         curr.next = null;
        //     curr = curr.next;
        // }
        
        
        
        
        
        return head;
        
        
    }
    
    private ListNode moveHead(ListNode head){ 
         while(head.next!=null && head.val==0)
            head = head.next;
        
         return head;
    }
    
    private ListNode appendVal(ListNode head){
         while(head.next!=null && head.next.val!=0){
            head.val += head.next.val;
            head.next = head.next.next;
         }
        
        return head;
            
    }
    
}