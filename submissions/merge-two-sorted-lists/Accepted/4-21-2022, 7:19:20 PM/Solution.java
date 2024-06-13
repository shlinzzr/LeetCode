// https://leetcode.com/problems/merge-two-sorted-lists

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode curr = new ListNode();
        ListNode head = new ListNode();
        
        if(list1==null)
            head.next = list2;
         if(list2==null)
            head.next = list1;
        
        
        
        
        while(list1 !=null && list2!=null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            
            curr = curr.next;
            
            if(head.next==null)
                head.next = curr;
            
        }
        
        if(list1 !=null){
           curr.next = list1;  
        }
        
        if(list2 !=null){
           curr.next = list2;  
        }
        
        
        return head.next;
        
    }
}