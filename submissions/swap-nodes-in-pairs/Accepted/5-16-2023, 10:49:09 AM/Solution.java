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
        
        if(head==null || head.next==null)
            return head;
        
        ListNode s1 = head;
        ListNode s2 = head.next;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        
        while(s1!=null && s2!=null){
            
            ListNode ns1 = s2.next;
            ListNode ns2 = ns1==null? null : s2.next.next;
            
            prev.next = s2;
            s2.next = s1;
            s1.next=ns1;
            
            prev = s1;
            s2 = ns2;
            s1 = ns1;
                
        }
        
        return dummy.next;
        
        
        
    }
}