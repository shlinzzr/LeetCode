// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer

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
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        
        int prod = 1;
        int sum = 0;
        
        while(curr!=null){
            
            sum = sum<<1;
            int val = curr.val;
            
            sum+=val;
            // System.out.println(val + " "  + sum);
            
            
            
            curr= curr.next;
            
            
            
            
            
            
        }
        
        return sum;
    }
}