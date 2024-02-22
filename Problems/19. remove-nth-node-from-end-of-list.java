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
        
        int cnt= 0 ;
        
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            cnt++;
        }
        if(cnt==1) return null;
        if(n==cnt) return head.next; 
        
        n = cnt-n-1;
        
        // a b c d e
        // 5-2
        curr= head;
        while(n>0){
            curr=curr.next;
            n--;
        }
        if(curr.next!=null)
            curr.next = curr.next.next;
        
        return head;
        
        
    }
}