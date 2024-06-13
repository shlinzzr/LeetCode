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
        
        ListNode cur = head;
        head = cur.next;
        
        ListNode prev = null;
        while(cur!=null){
            ListNode odd = cur;
            ListNode even = cur.next;
            ListNode next = null;
            if(even!=null){
                next = even.next;
            }
            
            if(prev!=null)
                prev.next = even;
            
            if(even!=null)
                even.next = odd;
            
            odd.next = next;
            cur = next;
            prev = odd;
        }
        
        return head;
    }
}