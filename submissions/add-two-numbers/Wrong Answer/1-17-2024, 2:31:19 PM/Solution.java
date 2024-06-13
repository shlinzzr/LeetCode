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
        int carry = 0;
        
        ListNode res = l1;
        ListNode t1 = l1, t2=l2;
        while(t1!=null && t2!=null){
            
            if(t1!=null && t2==null){
                break;
            }else if(t1==null && t2!=null){
                return addTwoNumbers(l2, l1);
            }
            t1=t1.next;
            t2=t2.next;
        }
        
        
        ListNode prev = null;
        while(l1!=null && l2!=null){
            l1.val += carry + l2.val;
            carry = l1.val/10;
            l1.val %=10;
            
            prev = l1;
            l1=l1.next;
            l2=l2.next;
        }
        
        
        while(l1!=null){
            l1.val += carry;
            carry = l1.val/10;
            l1.val%=10;
            prev =l1;
            l1=l1.next;
        }
        
        if(carry!=0){
            ListNode t = new ListNode(carry);
            prev.next = t;
        }
        
        return res;
    }
}