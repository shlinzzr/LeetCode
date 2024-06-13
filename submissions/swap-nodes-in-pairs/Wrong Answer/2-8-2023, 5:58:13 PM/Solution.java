// https://leetcode.com/problems/swap-nodes-in-pairs

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
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();
        
        ListNode prev=null;
        ListNode curr = head;
        
        while(curr!=null && curr.next!=null){
            
            ListNode next = curr.next;
            ListNode nextnext = curr.next.next;
            
            if(prev!=null){
                prev.next = next;
                
            }else{
                res = next;
            }
            
            next.next = curr;
            curr.next=nextnext;
            
            
            prev = curr;
            curr=curr.next;
        }
        
        return res;
        
             
    }
}