// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list

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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        
        ListNode curr = head;
        ListNode next = head.next;
        
        while(next!=null){
            int g = gcd(curr.val, next.val);
            ListNode node = new ListNode(g);
            
            // System.out.println(curr.val + " " + node.val + " "+ next.val + " g="+g);
            
            node.next=next;
            curr.next = node;
            curr=next;
            next=curr.next;
        }
        
        
        System.out.println(gcd(10, 3));
        
        return head;        
        
        
        
        
        
        
    }
    
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}