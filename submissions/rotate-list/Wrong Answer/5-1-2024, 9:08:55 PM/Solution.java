// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        
        int cnt = 0;
        ListNode fast = head;
        while(fast!=null){
            cnt++;
            fast = fast.next;
        }

        

        k = k%cnt;
        fast = head;
        while(k-->0){
            fast = fast.next;
        }

        //  1    2  3  4   5
        //            slow   fast
        ListNode prev = new ListNode();
        ListNode prevfast = new ListNode();
        prevfast.next = fast;
        prev.next = head;
        ListNode slow = head;
        while(fast!=null){
            prev = slow;
            slow = slow.next;
            prevfast = fast;
            fast = fast.next;
        }

        prev.next = null;
        prevfast.next = head;

        return slow;


        
    }
}