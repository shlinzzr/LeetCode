// https://leetcode.com/problems/odd-even-linked-list

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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode odd_curr = odd;
        ListNode even = new ListNode();
        ListNode even_curr = even;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        
        ListNode curr = head;
        boolean flag = true;
        while(curr!=null){
            
            if(flag){
                odd_curr.next = curr;
                odd_curr = odd_curr.next;
            }else{
                even_curr.next = curr;
                even_curr = even_curr.next;
            }
            
            curr = curr.next;
            flag=!flag;
        }

        
             dummy.next = odd.next;
            odd_curr.next = even.next;
            even_curr.next = null;
        
        
        
       
        
        return dummy.next;
        
    }
}