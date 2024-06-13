// https://leetcode.com/problems/reorder-list

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
    public void reorderList(ListNode head) {
        
        ListNode rev = getRev(head);
        ListNode curr = head;
        
        while(curr.next!=rev && curr!=rev){
            ListNode next = curr.next;
            curr.next=rev;
            
            ListNode revNext = rev.next;
            
            if(rev.next!=curr && rev.next!=next)
                rev.next = next;
            
            curr=next;
            rev=revNext;
        }
        
        rev.next=null;
        
    }
    
    
    private ListNode getRev(ListNode head){
        
        ListNode rev=null;
        
        ListNode curr = head;
        ListNode prev= null;
        
        while(curr!=null){
            rev = new ListNode(curr.val);
            rev.next=prev;
            prev=curr;
            curr=curr.next;
        }
            
        return rev;
        
    }
}