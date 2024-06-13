// https://leetcode.com/problems/merge-k-sorted-lists

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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> a.val-b.val
        );
            
        for(ListNode node : lists){
            pq.offer(node);
        }
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        
        while(!pq.isEmpty()){
            ListNode p = pq.poll();
            curr.next = p;
            curr= curr.next;
            if(p.next!=null){
                pq.offer(p.next);
            }
        }
        
        return dummy.next;
        
        
    }
}