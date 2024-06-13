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
        
        if(k==0)
            return head;
        
        if(head==null)
            return null;
        
        int len=0;
        ListNode tail = null;
        ListNode curr = head;
        while(curr!=null){
            len++;
            tail = curr;
            curr=curr.next;
        }
        
        if(len==1)
            return head;
        
        
        k = len - k % len;
        if(k>0)
            tail.next = head;
        
        
        ListNode prev = null;
        
        curr = head;
        while(k>0){
            
            prev=curr;
            curr=curr.next;
            k--;
        }
        
       
        
        prev.next=null;
        return curr;
        
        
    
    }
}