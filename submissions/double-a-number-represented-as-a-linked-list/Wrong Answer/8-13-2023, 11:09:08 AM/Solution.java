// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list

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
    public ListNode doubleIt(ListNode head) {
        ListNode curr = rev(head);
        
        int carry = 0;
        
        ListNode prev = null;
        ListNode temp = curr;
        while(curr!=null){
            
            curr.val = (curr.val*2 + carry)%10;
            carry = (curr.val*2+carry)/10;
            
            
            prev= curr;
            curr = curr.next;
        }
        
        
        
        if(carry!=0){
            prev.next = new ListNode(carry);
            prev = prev.next;
        }
        
        return rev(temp);
        
        
        
    }
    
    private ListNode rev(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
        
        
    }
}