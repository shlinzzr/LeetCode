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
        for(int i=0; i<lists.length; i++){
            ListNode node = lists[i];
            pq.offer(new Tuple(node.val, node));
        }
        
        ListNode curr = new ListNode();
        ListNode head = new ListNode();
        head.next = curr;
        
        while(!pq.isEmpty()){
//             System.out.println();
//              for( Tuple t : pq){
                 
//             System.out.println(t.node.val);
//         }
            
            
            Tuple t = pq.poll();
            
            ListNode node = t.node;
            curr.next = node;
            curr = curr.next;
            
            if(node.next==null)
                continue;
            
            pq.offer(new Tuple(node.next.val, node.next));
        }
        
        return head.next.next;
        
    }
}
class Tuple implements Comparable<Tuple>{
    ListNode node;
    int val;
    
    public Tuple(int val, ListNode node){
        this.val = val;
        this.node = node;
    }
    
    @Override 
    public int compareTo(Tuple that){
        return this.val-that.val;
    }
}