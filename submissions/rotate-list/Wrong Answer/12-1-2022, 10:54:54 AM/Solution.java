// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {
        int len =0;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            prev= curr;
            curr=curr.next;
            len++;
        }
        ListNode tail = prev;
        
        curr=head;
        int step=0;
        while(step < len-k-1){
            curr= curr.next;
            step++;
        }
        ListNode next = curr.next;
        curr.next=null;
        tail.next = head;
        
        return next;
        
        
        
    }
}