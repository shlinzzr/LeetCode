// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int len = 0;
        while(node!=null){
            len++;
            node=node.next;
        }
        
        len = len-n;
        node = head;
        // ListNode dummy = new ListNode();
        // dummy.next = head;
        
        ListNode prev=null;        
        
        while(len>0){
            len--;
            prev = node;
            node=node.next;
        }
        
        ListNode next = node.next;
        if(prev!=null)
            prev.next = next;
        else {
            head=next;
        }
        
        return head;
        
            
    }
}