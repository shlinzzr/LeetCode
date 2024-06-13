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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.val, b.val)
        );
        
        for(int i=0; i<len; i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        while(pq.size()>0){
            ListNode p = pq.poll();
            
            ListNode node = new ListNode(p.val);
            curr.next = node;
            curr=curr.next;
            
            if(p.next!=null){
                pq.offer(p.next);
            }
        }
        
        return dummy.next;
        
        
    }
}