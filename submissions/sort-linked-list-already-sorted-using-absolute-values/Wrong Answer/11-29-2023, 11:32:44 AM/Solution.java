// https://leetcode.com/problems/sort-linked-list-already-sorted-using-absolute-values

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
    public ListNode sortLinkedList(ListNode head) {

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode curr = head;

        ListNode front = dummy;

        while(curr!=null){

            ListNode next = curr.next;

            if(curr.val>=0){
                front.next = curr;
                front = front.next;
            }else{
                ListNode tmp = dummy.next;
                dummy.next = curr;
                curr.next = tmp;
            }

            curr = next;
        }
        front.next = null;

        return dummy.next;


    }
}