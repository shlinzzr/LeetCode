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
            
            
            boolean conA = set.contains(headA);
            if(headA!=null && !conA)
                set.add(headA);
            else if(conA)
                return headA;

            
            boolean conB = set.contains(headB);
            if(headB!=null && !conB)
                set.add(headB);
            else  if(conB)
                return headB;
            
            
            if(headA!=null)
                headA = headA.next;
            
            if(headB!=null)
                headB = headB.next;
        }
        
        while(headA!=null){
            
             boolean conA = set.contains(headA);
            if(headA!=null && !conA)
                set.add(headA);
            else if(conA)
                return headA;
            
            headA = headA.next;
        }
        
        
        while(headB!=null){
            boolean conB = set.contains(headB);
            if(headB!=null && !conB)
                set.add(headB);
            else  if(conB)
                return headB;
            
             headB = headB.next;
        }
        
        return null;
        
        
            
            
        
    }
}