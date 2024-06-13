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
        
        int len = 0;
        ListNode curr=head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        
        if(len==0)
            return null;
        
        k=k%len;
        k=len-k-1;
        curr=head;
        for(int i=0; i<k; i++){
            curr=curr.next;
        }
        ListNode newHead = curr.next;
        curr.next=null;
        
        ListNode prev= null;
        curr=newHead;
        while(curr!=null){
            prev= curr;
            curr=curr.next;
        }
        
        if(prev!=null)
            prev.next=head;
        
        
        return newHead;
    }
}