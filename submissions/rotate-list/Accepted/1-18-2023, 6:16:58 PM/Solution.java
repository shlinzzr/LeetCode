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
        
        ListNode curr = head;
        int len = 0;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        
        k = k%len;
        if(len==1  || k==0)
            return head;
        
        
        int step =len-k;
        curr=head;
        
        
        ListNode prev = null;
        while(curr!=null &&step>0){
            prev=curr;
            curr=curr.next;
            step--;
        }
        prev.next=null;
        ListNode newHead = curr;
        
        
        while(curr!=null){
            prev=curr;
            curr=curr.next;
        }
        prev.next = head;
        
        return newHead;
        
        
    }
}