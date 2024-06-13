// https://leetcode.com/problems/reorder-list

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
    public void reorderList(ListNode head) {
        
//         if(head==null)
//             return null;
        
        int len=0;
        
        
        // create reverse list
        ListNode curr =head;
        ListNode prev = null;
        while(curr!=null){
            ListNode node = new ListNode(curr.val);
            node.next=prev;
            prev = node;
            curr=curr.next;
            len++;
        }
        
        if(len==1)
            return;
        
        boolean isOdd = len%2==1;
        len = len/2;
        curr=head;
        
        ListNode prevprev = null;
        
        
        while(len>0){
            
            ListNode currNext = curr.next;
            ListNode prevNext = prev.next;
            curr.next=prev;
            curr=currNext;
            prev.next = curr;
            prevprev = prev;
            prev = prevNext;
            len--;
        }
        
        if(!isOdd)
            prevprev.next=null;
        
        
//         if(isOdd){
            
//         }
        
        
//         return dummyl1.next;
        
        
        
        
    }
    
    
    private ListNode reverse(ListNode head){
        
        ListNode prev =null;
        while(head!=null){
            ListNode next = head.next;
            head.next=prev;
            prev = head;
            head = next;
        }
            
        return prev;        

        
    }
}