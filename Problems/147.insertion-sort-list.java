// https://leetcode.com/problems/insertion-sort-list

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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        
        ListNode curr = dummy;
        
        while(head!=null){
            
            while(curr.next!=null && curr.next.val<head.val){
                curr=curr.next;
            }
            
            ListNode next = curr.next;
            
            
            curr.next = new ListNode(head.val);
            if(next!=null)
                curr.next.next = next;
            
            curr = dummy;
            
            
            head=head.next;
        }
        
        return dummy.next;
    }
}