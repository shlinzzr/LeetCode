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
        ListNode curr = head;
        
        int len =0;
        while(curr!=null){
            curr=curr.next;
            len++;
        }
        
        n=len-n;

        if(n==0){
            head=head.next;
            return head;
        }
        
        curr=head;
        for(int i=0; i<n-1; i++){
            curr=curr.next;
        }
        ListNode next = curr.next.next;
        curr.next=next;
        return head;
        
        
    }
}