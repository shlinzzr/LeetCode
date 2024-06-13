// https://leetcode.com/problems/partition-list

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
    public ListNode partition(ListNode head, int x) {
        List<ListNode[]> list = new ArrayList<>();
        
        ListNode dummy =new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        
        ListNode curr = head;
        while(curr!=null){
            
            if(curr.val>=x)
                list.add(new ListNode[]{prev, curr});
            
            prev = curr;
            curr=curr.next;
        }
        
        
        for(int i=list.size()-1 ;i>=0; i--){
            
            ListNode[] p = list.get(i);
            p[0].next = p[1].next;
        }
        
        prev= dummy;
        curr = dummy.next;
        while(curr!=null){
            prev = curr;
            curr=curr.next;
        }
        
        for(ListNode[] p : list){
            prev.next = p[1];
            prev = p[1];
            
        }
        prev.next = null;
        
        return dummy.next;
    }
}