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
    class Tuple{
        int val;
        ListNode node;
        int row;

        public Tuple(int val, ListNode node, int row){
            this.val=val;
            this.node=node;
            this.row = row;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {


        PriorityQueue<Tuple> pq = new PriorityQueue<>(
            (a,b)-> a.val-b.val
        ); // r, c

        int len = lists.length;
        for(int r=0; r<len; r++){
            ListNode node = lists[r];
            if(node==null) continue;

            Tuple t = new Tuple(node.val, node, r);
            pq.offer(t);   
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            if(t==null) continue;
            ListNode node = new ListNode(t.val);
            curr.next = node;
            curr = curr.next;

            if(t.node.next!=null){
                ListNode nxt = t.node.next;
                pq.offer(new Tuple(nxt.val, nxt, t.row));
            }
        }

        return dummy.next;
    }
}