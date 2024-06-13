// https://leetcode.com/problems/sort-list

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
    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null) return head;

        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = new ListNode();

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }        
        prev.next = null;


        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);

    }

    private ListNode merge(ListNode left, ListNode right){

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(left!=null && right!=null){

            if(left.val<=right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }  
            curr = curr.next;

        }

        while(left!=null){
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }

        while(right!=null){
            curr.next = right;
            right = right.next;
            curr = curr.next;
        }

        return dummy.next;

    }
}