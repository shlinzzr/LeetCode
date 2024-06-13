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
        ListNode c1=l1, c2=l2;
        while(c1!=null && c2!=null){
            int sum =(c1.val+c2.val) + carry;
            c1.val = sum%10;
            carry = sum/10;
            
            c1=c1.next;
            c2=c2.next;
        }
        
        return l1;
    }
}