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
        
        if (head == null || head.next == null)
            return head;
        
        
        
        ListNode fast=head, slow=head, prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null)
            prev.next=null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        ListNode res = mergeHalves(l1, l2);
        
        return res;
    }
    
    
    private ListNode mergeHalves(ListNode l1, ListNode l2){
        
        ListNode head = new ListNode();
        ListNode curr = head;
        
        while(l1!=null && l2!=null){
            
            ListNode node = new ListNode();
            
            
            if(l1.val<=l2.val){
                node = new ListNode(l1.val);
                l1=l1.next;
                
            }else{
                node = new ListNode(l2.val);
                l2=l2.next;
            }
            
            curr.next = node;
            curr=curr.next;
        }
        
        while(l1!=null){
            ListNode node = new ListNode(l1.val);
            l1=l1.next;
            curr.next=node;
            curr=curr.next;
        }
        
        while(l2!=null){
            ListNode node = new ListNode(l2.val);
            l2=l2.next;
            curr.next=node;
            curr=curr.next;
        }
        
        return head.next;
        
    }
}