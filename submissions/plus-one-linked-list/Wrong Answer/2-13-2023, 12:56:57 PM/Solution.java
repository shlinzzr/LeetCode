// https://leetcode.com/problems/plus-one-linked-list

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
    public ListNode plusOne(ListNode head) {
        
        ListNode rev = reverse(head);
        ListNode prev = null;
        int carry=0;
        
        ListNode cur = rev;
        
        while(rev!=null){
            
            if(prev==null)
                rev.val+=1 + carry;
            
            int v = (rev.val)%10;
            carry = (rev.val)/10;
            rev.val=v;
            prev=rev;
            rev=rev.next;
        }
        
        
        if(carry==1){
            prev.next=new ListNode(1);
            prev=prev.next;
        }
        
        ListNode ret = reverse(cur);
        return ret;
        
    }
    
    private ListNode reverse(ListNode node){
        
        ListNode prev =null;
        while(node!=null){
            ListNode next = node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        
        return prev;
        
    }
}
