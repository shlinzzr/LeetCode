// https://leetcode.com/problems/partition-list

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
    public ListNode partition(ListNode head, int x) {
        

        List<ListNode> small = new ArrayList<>();
        List<ListNode> large = new ArrayList<>();

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;

        while(curr!=null){

            if(curr.val<x){
                small.add(curr);
            }else{
                large.add(curr);
            }
            curr= curr.next;
        }

        ListNode prev = null;
        for(ListNode node : small){
            if(prev==null){
                head=node;
                prev= node;
            }else{
                prev.next = node;
                prev= node;
            }
        }

        for(ListNode  node : large){
            if(prev==null){
                head=node;
                prev=node;
            }else{
                prev.next = node;
                prev=node;
            }

        }
        if(prev!=null)
            prev.next = null;

        return head;

    }
}