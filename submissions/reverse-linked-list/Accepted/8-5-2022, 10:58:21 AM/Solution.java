// https://leetcode.com/problems/reverse-linked-list

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
    public ListNode reverseList(ListNode head) {
        
        ListNode node = new ListNode();
        ListNode prev = null;
        
        while(head!=null){
            node.next = head.next;
            head.next = prev;
            prev = head;
            head = node.next;
        }
        
        return prev;
            
    }
}