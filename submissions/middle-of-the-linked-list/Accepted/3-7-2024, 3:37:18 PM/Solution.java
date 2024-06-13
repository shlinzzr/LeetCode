// https://leetcode.com/problems/middle-of-the-linked-list

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
    public ListNode middleNode(ListNode head) {

        ListNode fast = head, slow = head;

        // 1 2 3 4 5
        //   s f
        //     s   f

        // 1 2 3 4 5 6 
        //   s f
        //     s.  f

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;

            if(fast.next!=null) 
                fast = fast.next;
        }

        return slow;
    }
}