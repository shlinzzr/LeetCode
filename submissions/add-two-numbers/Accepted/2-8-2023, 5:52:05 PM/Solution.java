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
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        int carry=0;
        
        while(l1!=null || l2!=null){
            int sum =carry;

            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            
            carry = sum/10;
            sum=sum%10;
            
            ListNode node = new ListNode(sum);
            curr.next=node;
            curr=curr.next;
        }
        
        if(carry!=0){
            ListNode node = new ListNode(carry);
            curr.next=node;
            curr=curr.next;
        }
        
        
        return dummy.next;
    }
}