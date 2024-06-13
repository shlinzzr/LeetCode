// https://leetcode.com/problems/winner-of-the-linked-list-game

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
    public String gameResult(ListNode head) {

        int odd = 0, even = 0;

        while(head!=null){

            int ev = head.val;
            int od = head.next.val;

            if(ev>od){
                even++;
            }else if(ev<od){
                odd++;
            }
            head = head.next.next;
        }

        if(odd>even) return "Odd";
        if(odd<even) return "Even";

        return "Tie";



        
    }
}