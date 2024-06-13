// https://leetcode.com/problems/middle-of-the-linked-list

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
    public ListNode middleNode(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
            
            if(fast!=null)
                fast=fast.next;
            
            if(fast.next==null)
                break;
             
            
        }
        return slow;
        
    }
}