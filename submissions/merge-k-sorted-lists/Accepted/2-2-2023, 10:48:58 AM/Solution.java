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
        int len = lists.length;
        
        for(int i=0; i<len ; i++){
            if(lists[i]!=null)
                pq.offer(lists[i]);
        }
        
        ListNode head = new ListNode();
        ListNode curr = head;
        
        while(!pq.isEmpty()){
            ListNode t = pq.poll();
            
            curr.next = t;
            
            
            if(t.next!=null){
                pq.offer(t.next);
            }
            curr=curr.next;
            
        }
        
        
        return head.next;
        
        
        
        
    }
}