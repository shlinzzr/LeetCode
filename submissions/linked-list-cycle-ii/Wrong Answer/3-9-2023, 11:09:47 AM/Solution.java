// https://leetcode.com/problems/linked-list-cycle-ii

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
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head, slow=head;
        
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast=fast.next.next;
            
            if(slow==fast)
                break;
        }
        
        slow= head;
        
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
            
        }
        
        return slow;
        
    }
}