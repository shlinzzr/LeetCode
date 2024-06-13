// https://leetcode.com/problems/plus-one-linked-list

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
    public ListNode plusOne(ListNode head) {

        

        ListNode rev = reverse(head);
        ListNode curr = rev;

        boolean carry = true;
        while(carry && curr!=null){

            
            curr.val += 1;
            if(curr.val/10==1){
                curr.val%=10;
                carry=true;
                curr=curr.next;
            }else 
                break;
        }

        return reverse(rev);
    }

    private ListNode reverse(ListNode head){
        ListNode prev =null;
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