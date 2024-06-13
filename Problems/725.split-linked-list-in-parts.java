// https://leetcode.com/problems/split-linked-list-in-parts

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        
        int len =0;
        ListNode curr = head;
        while(curr!=null){
            curr= curr.next;
            len++;
        }
        
        

        curr = head;
        
        ListNode prev = new ListNode();
        prev.next = curr;
        
        while(curr!=null){
            list.add(prev);

            int each = len/k + (len%k>0? 1: 0);
            len--;
            
            for(int i=0; i<each; i++){
                if(curr!=null){
                    prev = curr;
                    curr= curr.next;
                }
            }
        }
        
        ListNode[] res = new ListNode[k];
        
        for(int i=0; i<list.size(); i++){
            prev = list.get(i);
            res[i] =prev.next;
            prev.next = null;
        }
        
        return res;
        
    }
}