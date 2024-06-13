// https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list

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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        

        ListNode curr = head;

        ListNode prev = new ListNode();
        prev.next = curr;
        
        while(curr!=null){
            int cnt = m;
            while(curr!=null && cnt-->0){
                prev=curr;
                curr=curr.next;
            }

            int rm = n;
            while(curr!=null && rm-->0){
                curr=curr.next;
            }

            prev.next = curr;
        }

        return  head;
    }
}