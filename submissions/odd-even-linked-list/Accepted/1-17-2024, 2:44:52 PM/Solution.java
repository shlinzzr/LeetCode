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
        ListNode even = new ListNode();
        
        ListNode oddHead = odd;
        ListNode evenHead = even;
        
        ListNode curr = head;
        while(curr!=null){
            
            odd.next = curr;
            odd=odd.next;
            
            ListNode next = curr.next;
            if(next!=null){
                even.next = next;
                even = even.next;
                
                curr = next.next;
            }else{
                break;
            }
        }
        even.next = null;
        
        odd.next=evenHead.next;
        return oddHead.next;
        
        
        
    }
}