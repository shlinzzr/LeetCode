// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left==right)
            return head;
        
        ListNode prev = new ListNode();
        prev.next = head;
        
        ListNode curr = head;
        int cnt = 1;
        
        while(cnt<left && curr!=null){
            prev = curr;
            curr=curr.next;
            cnt++;
        }
        
        ListNode leftTail = prev;
        ListNode midTail = curr;
        
        
        while(curr!=null && cnt<right){
            prev=curr;
            curr=curr.next;
            cnt++;
        }
        
        ListNode rightHead = curr.next;
        curr.next = null;
        
        ListNode midHead = reverse(leftTail.next);
        ListNode leftHead = (left==1? midHead : head);
        
        leftTail.next = midHead;
        midTail.next = rightHead;
        
        return leftHead;
        
    }
    
    
    private ListNode reverse(ListNode node){
        
        ListNode prev = null;
        while(node!=null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
        
        
    }
}