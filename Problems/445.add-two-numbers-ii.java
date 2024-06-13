// https://leetcode.com/problems/add-two-numbers-ii

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
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        
        int carry =0;
        while(l1!=null || l2!=null || carry==1){
            
            ListNode node = new ListNode();
            curr.next = node;
            curr = curr.next;
            
            
            int sum = carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            
            curr.val = sum%10;
            carry = sum/10;
            
        }
        
        ListNode head = dummy.next;
        dummy.next = null;
        
        
        return reverse(head);
    }
    
    
    private ListNode reverse(ListNode l1){
        
        ListNode prev=null;
        ListNode curr =l1;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        
        return prev;
    }
    
}