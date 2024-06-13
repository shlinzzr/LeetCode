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
        if(head==null) return head;

        ListNode fast = head;
        int len = 0;
        while(fast!=null){
            len++;
            fast= fast.next;
        }
        k%=len;

        if(k==0) return head;


        int cnt = 0;
        fast = head;
        while(cnt<k){
            fast=fast.next;
            cnt++;
        }


        ListNode prev_slow =null;
        ListNode prev_fast =null;

        ListNode slow = head;
        while(fast!=null){
            prev_slow = slow;
            slow = slow.next;

            prev_fast = fast;
            fast = fast.next;
        }

        if(prev_slow!=null) prev_slow.next = null;
        if(prev_fast!=null) prev_fast.next = head;
        
        return slow;


        //0 1 2 
        //  f
        //    s

        


        
    }
}