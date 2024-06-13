// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int cnt=0;
        while(node!=null){
            cnt++;
            map.put(cnt, node);
            node = node.next;
        }
        
        if(cnt==n)
            return head.next;            
        
        
        
        ListNode prev = map.get(cnt-n);
        node = map.get(cnt-n+1);
        
        if(prev!=null){
            if(node!=null)
                prev.next=node.next;
        }
            
        
        return head;
        
        
        
    }
}