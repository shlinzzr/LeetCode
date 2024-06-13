// https://leetcode.com/problems/merge-in-between-linked-lists

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode curr = list1;
        ListNode prev = dummy;

        int i=0;
        while(curr!=null){

            if(i==a){
                prev.next = list2;

                while(list2.next!=null){
                    list2 = list2.next;
                }

                while(i!=b+1){
                    curr=curr.next;
                     i++;
                }

                list2.next = curr;
                break;
            }
            i++;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
        
    }
}