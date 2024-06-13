// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

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
    public ListNode deleteDuplicates(ListNode head) {
       
        if(head==null)
            return null;
        
        ListNode curr = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev=dummy;
        
        while(curr!=null){
            boolean dul = false;
            while(curr!=null && curr.next!=null && curr.val == curr.next.val){
                curr=curr.next;
                dul=true;
            }
            
            if(dul)
                curr=curr.next;
            
            prev.next = curr;
            prev = curr;
            curr=curr.next;
        }
        
        return dummy.next;
        
        
        
    }
}