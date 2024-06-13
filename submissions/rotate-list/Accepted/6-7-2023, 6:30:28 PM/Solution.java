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
        int len = 0 ;
        ListNode curr = head;
        while(curr!=null){
            curr=curr.next;
            len++;
        }
        
        if(head ==null)
            return head;
        
        k = k%len;
        
        if(len==1 || k==0)
            return head;
        
        curr = head;
        k=len-k-1;
        for(int i=0; i<k; i++){
            curr=curr.next;
        }
        
        ListNode newHead = curr.next;
        curr.next = null;
        
        
        curr=newHead;
        ListNode prev = null;
        while(curr!=null){
            prev=curr;
            curr = curr.next;
        }
        
        prev.next = head;
        
        return newHead;
        
            
            
    }
}