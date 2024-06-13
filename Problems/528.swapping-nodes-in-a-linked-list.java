// https://leetcode.com/problems/swapping-nodes-in-a-linked-list

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode a = head;
        int t = k-1;
        
        while(t>0 && a!=null){
            a=a.next;
            t--;
        }
        
        ListNode rev = reverse(head);
        ListNode b = rev;
        t = k-1;
        while(t>0 && b!=null){
            b=b.next;
            t--;
        }
        
        int  tmp = a.val;
        a.val=b.val;
        b.val = tmp;
        
        
        head = reverse(rev);
        
        
        return head;
        
        
    }
    
    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
        
        
    }
    
}