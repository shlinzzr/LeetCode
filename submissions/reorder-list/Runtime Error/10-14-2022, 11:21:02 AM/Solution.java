// https://leetcode.com/problems/reorder-list

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
    public void reorderList(ListNode head) {
        
        // create reverse list
        
        ListNode curr = head;
        ListNode prev = null;
        int len=0;
        while(curr!=null){
            ListNode node = new ListNode(curr.val);
            node.next = prev;
            prev=node;
            curr=curr.next;
            len++;
        }
        
        boolean isOdd = len%2==1;
        
        len=len/2;
        curr = head;
        ListNode currNextNext = null;
        
        
        
        ListNode temp = null;
        while(len>0){
            
            if(temp!=null)
                temp.next=curr;
            
            ListNode currNext = curr.next;
            ListNode revNext = prev.next;
            
            curr.next = prev;
            
            curr = currNext;
            temp=prev;
            prev = revNext;
            len--;            
            
        }
        
        if(isOdd){
            temp.next= curr;
            curr.next=null;
        }else
            temp.next=null;
            
        
        
    }
}