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
        List<ListNode> small = new ArrayList<>();
        List<ListNode> big = new ArrayList<>();
        
        ListNode curr = head;
        while(curr!=null){
            
            if(curr.val<x)
                small.add(curr);
            else 
                big.add(curr);
            
            curr = curr.next;
        }
        
        
        for(int i=0; i<small.size()-1; i++){
            small.get(i).next = small.get(i+1);
        }
        
        for(int i=0; i<big.size()-1; i++){
            big.get(i).next = big.get(i+1);
        }
        
        if(!small.isEmpty()){
            curr = small.get(0);
            
            if(!big.isEmpty()){
                small.get(small.size()-1).next = big.get(0);
                big.get(big.size()-1).next=null;
            } else
                small.get(small.size()-1).next = null;
        }else {
            curr = big.get(0);
            big.get(big.size()-1).next=null;
        }
            
        
        
        return curr;
        
    }
}