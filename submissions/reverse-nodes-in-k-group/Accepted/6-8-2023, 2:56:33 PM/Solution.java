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
        
        if(head==null)
            return head;
        
        List<ListNode> list = new ArrayList<>();
        
        ListNode curr = head;
        ListNode currHead = head;
        list.add(currHead);
        
        boolean needRev = false;
        
        int cnt =0;
        while(curr!=null){
            cnt++;
            needRev=false;
            if(cnt==k){
                cnt=0;
                needRev=true;
                currHead = curr.next;
                
                curr.next = null;
                curr = currHead;
                if(currHead!=null)
                    list.add(currHead);
            }else
                
                curr=curr.next;
        }
        
        ListNode dummy = new ListNode();
        ListNode prev = null;
        for(int i=list.size()-1; i>=0; i--){
            
            ListNode node = list.get(i);         
            if(i==list.size()-1){
                
                if(needRev){
                    prev = reverse(node, prev);
                }else{
                    prev = node;
                }
            }else{
                prev = reverse(node, prev);
            }
        }
        
        return prev;
        
    }
    
    
    private ListNode reverse(ListNode node, ListNode prev){
        
        ListNode curr = node;
        while(curr!=null){
            
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
        
        
        
    }
}