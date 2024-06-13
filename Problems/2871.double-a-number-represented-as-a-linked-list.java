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

        if(head==null) return head;

        ListNode rev = reverse(head);

        int carry = 0;

        ListNode prev = new ListNode();
        ListNode curr = rev;
        while(curr!=null){

            int val = curr.val*2 + carry;
            carry = val/10;
            val %= 10;
            curr.val = val;
            prev = curr;
            curr = curr.next;

        }

        if(carry!=0){
            ListNode node = new ListNode(1);
            prev.next = node;
        }

        return reverse(rev);
            
        
        
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node!=null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;   
        }

        return prev;
    }
}