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
        //merge sort
        
        if (head == null || head.next == null)
            return head;
        
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev!=null)
            prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeList(l1, l2);
        
        
    }
    
    private ListNode mergeList(ListNode l1, ListNode l2){
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        
        while(l1!=null && l2!=null){
            
            if(l1.val<=l2.val){
                ListNode node = new ListNode(l1.val);
                curr.next = node;
                l1=l1.next;
            }else{
                ListNode node = new ListNode(l2.val);
                curr.next = node;
                l2=l2.next;
            }
            curr=curr.next;
        }
        
        
       while(l1!=null){
            ListNode node = new ListNode(l1.val);
            l1=l1.next;
            curr.next = node;
            curr = curr.next;
        }
        
        while(l2!=null){
            ListNode node = new ListNode(l2.val);
            l2=l2.next;
            curr.next = node;
            curr = curr.next;
        }
        
        return dummy.next;
        
    }
}
