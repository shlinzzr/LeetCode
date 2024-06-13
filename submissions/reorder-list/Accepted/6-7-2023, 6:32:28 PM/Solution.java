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
        
        if(head==null)
            return ;
        
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode l2 = getRev(slow.next);  // 1 2 3 4 5 6 => 1 2 3 / 6 5 4 => 1 6 2 5 3 4
        slow.next = null; 
        
       
        ListNode l1 = head;
        
        
        while(l1!=null && l2!=null){
            ListNode n1 = l1.next;
            l1.next = l2;
            ListNode n2= l2.next;
            l2.next = n1;
            l1=n1;
            l2=n2;
        }
        
        
        
    }
    
    
    private ListNode getRev(ListNode head){
        
        ListNode rev=null;
        
        ListNode curr = head;
        ListNode prev= null;
        
        while(curr!=null){
            rev = new ListNode(curr.val);
            rev.next=prev;
            prev=rev;
            curr=curr.next;
        }
        
        return rev;
        
    }
}