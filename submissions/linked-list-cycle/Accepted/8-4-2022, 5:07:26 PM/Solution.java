// https://leetcode.com/problems/linked-list-cycle

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast =head, slow = head;
        
        
        while(fast!=null){
            fast = fast.next;
            
            if(fast!=null)
                fast=fast.next;
            else
                break;
            
            slow = slow.next;
            
            if(slow==fast)
                return true;
                
            
        }
        
        return false;
    }
}