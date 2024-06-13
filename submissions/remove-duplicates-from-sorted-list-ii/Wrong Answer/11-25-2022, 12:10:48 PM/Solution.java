// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

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
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode curr=head;
        
        while(curr!=null){
            
            while(curr.next!=null && curr.val==curr.next.val){
                curr=curr.next;
            }
            
            if(prev.next==curr){
                prev=prev.next;
            }
            else{
                prev.next=curr.next;
            }
            curr=curr.next;
            
            
//             prev.next = curr.next;
            
//             prev = curr;
//             curr=curr.next;
        }
        
        return head;
    }
}