// https://leetcode.com/problems/palindrome-linked-list

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode newHead = reverse(slow);
        
        while(newHead!=null && head!=null){
            if(newHead.val!=head.val)
                return false;
            newHead=newHead.next;
            head = head.next;
        }
        return true;
      
        
    }
    
    private ListNode reverse(ListNode mid){
        ListNode prev = null;
        while(mid!=null){
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
            
        }
        
        
        return prev;
        
            
    }
}