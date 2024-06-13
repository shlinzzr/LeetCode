// https://leetcode.com/problems/reverse-nodes-in-k-group

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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        List<ListNode> list = new ArrayList<>();
        
        ListNode curr = head;
        ListNode prev= null;
        while(curr!=null){
            list.add(curr);
            for(int i=0; i<k && curr!=null; i++){
                prev = curr;
                curr=curr.next;
            }
            
            if(prev!=null)
                prev.next = null;
        }
        
        ListNode tail = null;
        for(int i=list.size()-1; i>=0; i--){
            ListNode n = list.get(i);
            
            if(i==list.size()-1)
                tail = n;
            else
                tail = reverse(n, tail);
        }
        
        return tail;
        
    }
    
    
    private ListNode reverse(ListNode head, ListNode tail){
        
        
        ListNode curr = head;
        ListNode prev = tail;
        while(curr!=null){
            
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        
        
        return prev;
    }
}