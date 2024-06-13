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
        
        ListNode mid = head;
        
        while(head.next!=null){
            
            mid = mid.next;
            
            head = head.next;
            if(head.next!=null)
                head=head.next;
            
        }
        
        return mid;
        
        
    }
}