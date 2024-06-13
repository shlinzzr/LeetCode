// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list

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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        List<Integer> list = new ArrayList<>();
        
        
        while(fast!=null && fast.next!=null){
            
            list.add(slow.val);
            fast = fast.next.next;
            slow = slow.next;
            
        }
        
        ListNode rev = reverse(head);
        fast = rev;
        slow = rev;
         
        int idx = 0;
        int max = 0;
        while(fast!=null && fast.next!=null){
            max = Math.max(max , list.get(idx++)+slow.val);
             fast = fast.next.next;
            slow = slow.next;
            
            
            
        }
        
        return max;
        
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