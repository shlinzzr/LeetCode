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
        if(head==null) return null;
        
        ListNode prev = new ListNode();
        ListNode dummy = new ListNode();
        dummy.next = head;
        prev = dummy;
        ListNode curr=head;
        
        while(curr!=null){
            
            boolean dul = false;
            while(curr.next!=null && curr.val==curr.next.val){
                curr=curr.next;
                dul = true;
            }
            
            if(dul==false){
                prev=prev.next;
            }
            else{
                prev.next=curr.next;
            }
            curr=curr.next;
            
            
//             prev.next = curr.next;
            
//             prev = curr;
//             curr=curr.next;
        }
        
        return dummy.next;
    }
}