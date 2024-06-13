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
            pq.offer(lists[i]);
            // max = Math.max(max, lists[0].val);
        }
        
        ListNode head = new ListNode();
        ListNode curr = head;
        
        // int st=-10000, ed=max, range=ed-st;
        while(!pq.isEmpty()){
            ListNode t = pq.poll();
            
            curr.next = t;
            
            // if(max-t.node.val<range){
            //     st = t.node.val;
            //     ed = max;
            //     range = ed-st;
            // }
            
            if(t.next!=null){
                
                pq.offer(t.next);
                // max = Math.max(max, t.node.next.val);
            }
            curr=curr.next;
            
        }
        
        
        return head.next;
        
        
        
        
    }
    
    class Tuple{
        
        ListNode node;
        int row;
        
        public Tuple(ListNode node){
            this.node=node;
            // this.col=col;            
            // this.row=row;
        }
    }
}