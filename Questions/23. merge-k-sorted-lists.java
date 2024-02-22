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
        int len = lists.length;
        if(len==0) return null;
        
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> pq= new PriorityQueue<>(
            (a,b)-> a.val-b.val
        );
        
        for(ListNode node : lists){
            if(node!=null)
                pq.offer(node);
        }
        
        
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode p = pq.poll();
            
            curr.next = p;
            if(p.next!=null) 
                pq.offer(p.next);
            curr = curr.next;
        }
        
        return dummy.next;
        
    }
}