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
        ListNode fast = head, slow=head;
        
        // ListNode prev =null;
        while(fast!=null&& fast.next!=null){
            fast=fast.next;
            // prev= slow;
            slow=slow.next;
            
            if(fast!=null)
                fast=fast.next;
        }
        return slow;
    }
}