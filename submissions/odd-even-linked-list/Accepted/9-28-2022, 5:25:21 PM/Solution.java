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
        boolean isOdd=true;
        ListNode odd= new ListNode();
        ListNode even = new ListNode();
        ListNode evenHead = even;
        ListNode oddHead = odd;
        
        ListNode curr = head;
        while(curr!=null){
            
            if(isOdd){
                odd.next = curr;
                odd = odd.next;
            }else{
                even.next = curr;
                even = even.next;
            }
            
            isOdd=!isOdd;
            
            curr = curr.next;
            if(curr==null)
                even.next=null;
        }
        
        odd.next = evenHead.next;
        
        
        
         return oddHead.next;
    }
    
   
}