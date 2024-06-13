// https://leetcode.com/problems/merge-in-between-linked-lists

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        
        
        ListNode dummy = new ListNode();
        dummy.next=list1;
        
        ListNode curr = list1;
        
        ListNode prev = null;
        
        while(curr!=null){
            
            if(curr.val==a){
                ListNode rmCurr = curr;
                
                if(prev==null){
                    dummy.next = list2;
                }else{
                    prev.next = list2;    
                }
                curr=list2;
                while(curr.next!=null){
                    curr=curr.next;
                }
                
                
                
                while(rmCurr!=null){
                    if(rmCurr.val==b){
                        
                        ListNode tail = rmCurr.next;
                        curr.next = tail;
                        return list1;
                    }
                    rmCurr = rmCurr.next;
                }
            }
            prev = curr;
            curr=curr.next;
        }
        
        return dummy.next;
        
        
        
    }
}