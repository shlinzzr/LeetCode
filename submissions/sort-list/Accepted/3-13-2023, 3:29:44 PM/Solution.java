// https://leetcode.com/problems/sort-list

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
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        
        ListNode slow=head, fast=head, prev=null;
        
        while(fast!=null && fast.next!=null){
            
            fast=fast.next.next;
            prev= slow;
            slow=slow.next;
        }
        if(prev!=null)
            prev.next=null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        ListNode res = merge(left, right);
        
        return res;
        
        
    }
    
    private ListNode merge(ListNode left, ListNode right){
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        while(left!=null && right!=null){
            if(left.val<=right.val){
                curr.next = left;
                curr = curr.next;
                left = left.next;
            }else{
                curr.next = right;
                curr=curr.next;
                right = right.next;
            }
        }
        
        while(left!=null){
            curr.next = left;
            curr = curr.next;
            left = left.next;
        }
        
        while(right!=null){
            curr.next = right;
            curr=curr.next;
            right = right.next;
        }
        
        return dummy.next;
    }
}