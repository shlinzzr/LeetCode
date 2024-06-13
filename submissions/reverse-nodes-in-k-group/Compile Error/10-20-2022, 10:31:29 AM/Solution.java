// https://leetcode.com/problems/reverse-nodes-in-k-group

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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(k==1)
            return head;
        
        int len =0; 
        ListNode curr = head;
        while(curr!=null){
            curr=curr.next;
            len++;
        }
        
        int t = len/k;
        int i=0;
        curr = head;
        ListNode newHead = null;
        ListNode prev = curr;
        ListNode next = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        
        while(i<t){
            
            int j=0; // loop prev to nextHead;
            // currTail=prev;
            prev=curr;
            while(j<k){
                prev=prev.next;
                j++;
            }
            // if(i!=0)
            //     currTail.next = prev;
            
            
            j=0;
            while(j<k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                
                j++;
            }
            
            if(i==0)
                newHead = prev;
                
            else{
                
                ListNode tail = dummy.next;
                tail.next = prev;
                
                
                
            }
            
            currTail = nextCurrTail;
            // System.out.println(prev.val);
            // System.out.println(currTail.val);
            
            i++;
        }
        
        return newHead;
    
    }
}