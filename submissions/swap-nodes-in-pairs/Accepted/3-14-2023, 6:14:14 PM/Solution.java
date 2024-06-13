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
        ListNode prev = null;
        while(curr!=null && curr.next!=null){
            
            ListNode next = curr.next;
            ListNode nnxt = curr.next.next;
            
            if(prev!=null){
                prev.next=next;
            }else{
                head = next;
            }
            
            next.next = curr;
            curr.next = nnxt;
            
            prev=curr;
            curr=nnxt;
        }
        
        return head;
    }
}