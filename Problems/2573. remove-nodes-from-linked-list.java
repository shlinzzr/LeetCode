// https://leetcode.com/problems/remove-nodes-from-linked-list

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
    public ListNode removeNodes(ListNode head) {
        
        Set<ListNode> rmList = new HashSet<>();
        
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        
        while(curr!=null){
            
            while(!st.isEmpty() && st.peek().val<curr.val){
                rmList.add(st.pop());
            }
            
            st.push(curr);
            curr = curr.next;
        }
        
        ListNode prev = null;
        curr = head;
        
        while(curr!=null){
            
            if(rmList.contains(curr)){
                
                if(prev==null){
                    head = curr.next;
                }else{
                    
                    prev.next = curr.next;
                }
                
            }else{
                
                prev= curr;
                
            }
            curr=curr.next;
            
        }
        
        return head;
        
        
        
        
    }
}