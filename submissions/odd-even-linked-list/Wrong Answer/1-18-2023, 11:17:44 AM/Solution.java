// https://leetcode.com/problems/odd-even-linked-list

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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddhead = null;
        ListNode evenhead= null;
        ListNode oddcurr = null;
        ListNode evencurr= null;
        
        
        
        if(head==null)
            return null;
        else{
            if(head.val%2==0){
                evenhead=head;
                evencurr=head;
            }else{
                oddhead=head;
                oddcurr=head;
            }
        }      
        
        
        
        ListNode curr = head;
        while(curr!=null){

            ListNode next= curr.next;
            curr.next=null;
            
            if(curr.val%2==0){
                
                if(evenhead==null){
                    evenhead=curr;
                    evencurr=curr;
                }else{
                    evencurr.next=curr;
                    evencurr=curr;
                }
            }else{
                if(oddhead==null){
                    oddhead=curr;
                    oddcurr=curr;
                }else{
                    oddcurr.next=curr;
                    oddcurr=curr;
                }
            }            
            curr=next;
        }
        
        if(oddhead==null)
            return evenhead;
        
        if(evenhead==null)
            return oddhead;
        
        if(head.val%2==0){
            evencurr.next=oddhead;
            return evenhead;
        }else{
            oddcurr.next=evenhead;
            return oddhead;
        }
        
    
            
            
    }
}