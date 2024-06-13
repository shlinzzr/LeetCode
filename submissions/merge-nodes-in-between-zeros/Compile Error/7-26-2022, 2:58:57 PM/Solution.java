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

        ListNode rt = new ListNode()
        rt.next = head;
        
       
        
        
        while(head.next!=null){
            
            if(head.next.val==0)
                moveHead(head.next);
            else
                head.next = appendVal(head.next);
            
        }
        
        return rt.next;
        
        
    }
    
    private ListNode moveHead(ListNode head){  // head must be 0
         while(head.next!=null && head.next.val==0)
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