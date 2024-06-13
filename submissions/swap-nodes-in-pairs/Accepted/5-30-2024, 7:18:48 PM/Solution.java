// https://leetcode.com/problems/swap-nodes-in-pairs

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
    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next==null) return head;

        ListNode first = head;
        ListNode second = head.next;

        

        if(second.next==null){
            second.next = first;
            first.next=null;
            return second;
        }else{
            head = second;
        }
        ListNode prev = null;
        while(first!=null && second!=null){

            ListNode third = second.next;
            ListNode fourth = (third==null)? null : third.next;

            second.next = first;
            first.next = fourth!=null? fourth : third;
            first = third;
            second = fourth;
        }
        // if(first!=null) {
        //     prev.next = first;
        //     first.next = null;
        // }

        // if(prev!=null) prev.next = null;

        return head;
        
    }
}