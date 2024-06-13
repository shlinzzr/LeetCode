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
        
        int carry=0;
        ListNode c1=l1, c2=l2, prev=null;
        while(c1!=null || c2!=null){
            
            int c1Val = c1==null? 0 : c1.val;  
            int c2Val = c2==null? 0 : c2.val;
            
            int sum =(c1Val+c2Val) + carry;
            
            if(c1==null){
                c1 = new ListNode(sum%10);
                prev.next= c1;
            }else
                c1.val = sum%10;
            
            carry = sum/10;
                
            prev=c1;
            
            if(c1.next==null && carry!=0)
                c1.next = new ListNode(0);
            
            c1=c1.next;
            
            if(c2!=null)
                c2=c2.next;
            
            
            
        }
        
        
        
        return l1;
    }
}