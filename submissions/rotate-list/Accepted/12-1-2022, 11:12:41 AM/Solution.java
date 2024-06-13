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
        
        int len =0;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            prev= curr;
            curr=curr.next;
            len++;
        }
        
        if(len==0 || len==1)
            return head;
        
      
        
        // System.out.println(len);
        
        ListNode tail = prev;
        k = len-k%len;
        if(k>0)
            tail.next = head;

        
        // curr=head;
        // int step=0;
        // while(step < len-k-1){
        //     curr= curr.next;
        //     step++;
        // }
        
        curr = head;
        while(k>0){
            
            prev=curr;
            curr=curr.next;
            k--;
        }
        
           
        prev.next=null;
        return curr;
        
        
//         ListNode next = curr.next;
//         curr.next=null;
//         tail.next = head;
        
        // return next;
        
        
        
    }
}