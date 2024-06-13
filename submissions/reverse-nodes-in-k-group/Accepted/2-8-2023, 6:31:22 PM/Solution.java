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
        
        int c=0;
        ListNode prev=null;
        ListNode curr = head;
        while(curr!=null){
            
            if(c%k==0){
                if(prev!=null)
                    prev.next=null;
                list.add(curr);
            }
            
            prev=curr;
            curr=curr.next;
            c++;
        }
        
        
        boolean rev = c%k==0? true : false;
        
        curr = null;
        
        for(int i=list.size()-1; i>=0; i--){
            
            if(rev==false && i==list.size()-1){
                curr = list.get(i);
                
            }else{
                curr = reverse(list.get(i), curr);
            }
        }
        
        
        return curr;
        
        
            
    }
    
    
    private ListNode reverse(ListNode head, ListNode prev){
        
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }        
        
        return prev;
        
    }
    
}