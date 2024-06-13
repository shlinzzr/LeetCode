// https://leetcode.com/problems/intersection-of-two-linked-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        Set<ListNode > set = new HashSet<>();
        while(headA!=null || headB!=null){
            
            if(headA!=null && !set.contains(headA))
                set.add(headA);
            else if(set.contains(headA))
                return headA;
            
            if(headB!=null && !set.contains(headB))
                set.add(headB);
            else  if(set.contains(headB))
                return headB;
            
            
            if(headA!=null)
                headA = headA.next;
            
            if(headB!=null)
                headB = headB.next;
        }
        
        while(headA!=null){
               if(headA!=null && !set.contains(headA))
                set.add(headA);
            else if(set.contains(headA))
                return headA;
            
            headA = headA.next;
        }
        
        
        while(headB!=null){
            if(headB!=null && !set.contains(headB))
                set.add(headB);
            else  if(set.contains(headB))
                return headB;
             headB = headB.next;
        }
        
        return null;
        
        
            
            
        
    }
}