// https://leetcode.com/problems/reverse-nodes-in-k-group

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
    public ListNode reverseKGroup(ListNode head, int k) {
        
     
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        boolean hasTail = false;
        
        
        while(curr!=null){
            
            list.add(curr);
            for(int i=0; i<k-1; i++){
                
                if(curr.next == null){
                    hasTail=true;
                    break;                    
                }else 
                    curr = curr.next;
            }    
            
            ListNode tmp = curr.next;
            curr.next = null;
            curr = tmp;
        }
        
        for(int i=0; i<list.size(); i++){
            
            if(hasTail && i==list.size()-1){
                continue;
            }
            
            list.set(i, reverseList(list.get(i)));
        }
        
        for(int i=0; i<list.size()-1; i++){
            
            curr = list.get(i);
            
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next = list.get(i+1);
        }
        
        
        return list.get(0);
    
    }
    
    
    
    private ListNode reverseList(ListNode head){
        
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
            
        
    }
}