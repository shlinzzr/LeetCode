// https://leetcode.com/problems/add-two-numbers

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        int carry = 0;
        while(r1!=null || r2!=null || carry==1){

            int val =  carry;
            if(r1!=null){
                val+=r1.val;
                r1=r1.next;
            }
            
            if(r2!=null){
                val+=r2.val;
                r2=r2.next;
            }
            
            carry = val/10;
            val = val%10;
            
            ListNode node = new ListNode(val);
            curr.next = node; 
            curr=curr.next;
        }
        
        return dummy.next;
        
        
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev= null;
        
        while(head!=null){
            
            ListNode next = head.next;
            head.next=prev;
            prev=head;
            head= next;
        }
        
        return prev;
        
    }
}