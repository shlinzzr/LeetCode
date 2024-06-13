// https://leetcode.com/problems/reorder-list

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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = genRev(slow.next);
        slow.next = null;

        ListNode l1 = head;

        while(l1!=null && l2!=null){
            ListNode n1 = l1.next;
            l1.next = l2;
            ListNode n2 = l2.next;
            l2.next = n1;
            l1=n1;
            l2=n2;
        }

        
        
    }

    private ListNode genRev(ListNode node){

        ListNode prev = null;
        ListNode curr = node;
        while(curr!=null){
            ListNode rev = new ListNode(curr.val);
            rev.next = prev;
            prev = rev;
            curr = curr.next;
        }

        return prev;


    }
}