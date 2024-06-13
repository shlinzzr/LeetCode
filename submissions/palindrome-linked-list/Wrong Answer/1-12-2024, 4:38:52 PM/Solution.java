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
        int cnt= 0 ;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        ListNode next = slow.next;
        slow.next=null;
        fast = reverse(next);
        
//         while(fast!=null){
            
//             System.out.print(fast.val + " ,");
//             fast= fast.next;
//         }
        
//         while(head!=null){
//             System.out.print(head.val + " ,");
//             head = head.next;
//         }
        
        
        while(fast!=null && head !=null){
            if(fast.val!=head.val) return false;
            head = head.next;
            fast = head.next;
        }
        
        return true;
        
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