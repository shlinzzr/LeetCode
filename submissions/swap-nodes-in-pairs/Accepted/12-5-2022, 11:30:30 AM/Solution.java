// https://leetcode.com/problems/swap-nodes-in-pairs

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
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        
        ListNode prev= null;
        while(curr!=null && curr.next!=null){
            ListNode a = curr;
            ListNode b = curr.next;
            ListNode next = curr.next.next;
            
            if(prev!=null)
                prev.next = b;
            else{
                head = b;
            }
            
            
            
            b.next = a;
            a.next = next;
            prev = a;
            
            curr = next;
        }
        
        return head;
    }
}