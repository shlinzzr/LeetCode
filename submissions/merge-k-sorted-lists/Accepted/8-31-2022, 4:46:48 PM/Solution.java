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
        
        PriorityQueue<Tuple> pq = new PriorityQueue();
        for(ListNode node : lists){
            if(node!=null){
                Tuple t = new Tuple(node, node.val);
                pq.offer(t);    
            }
        }
        
        
        ListNode head = new ListNode();
        ListNode curr = head;
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            ListNode node = t.node;
            curr.next = node;
            
            if(node.next!=null){
                Tuple tt = new Tuple(node.next, node.next.val);    
                pq.offer(tt);
            }
            
            curr=curr.next;
        }
        
        
        return head.next;
        
    }
}

class Tuple implements Comparable<Tuple>{
    ListNode node;
    int val;
    
    public  Tuple(ListNode node, int val){
        this.node = node;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple tuple){
        return this.val-tuple.val;
    }
}

// class Tuple implements Comparable<Tuple>{
//     ListNode node;
//     int val;
    
//     public Tuple(int val, ListNode node){
//         this.val = val;
//         this.node = node;
//     }
    
//     @Override 
//     public int compareTo(Tuple that){
//         return this.val-that.val;
//     }
// }

