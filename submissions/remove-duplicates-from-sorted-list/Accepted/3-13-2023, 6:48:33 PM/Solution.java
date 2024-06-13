// https://leetcode.com/problems/remove-duplicates-from-sorted-list

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
    public ListNode deleteDuplicates(ListNode head) {
        
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev =dummy;
        
        ListNode curr = head;
        HashSet<Integer> set = new HashSet<>();
        
        while(curr!=null){
            if(set.contains(curr.val)){
                prev.next = curr.next;
            }else{
                prev=prev.next;
            }
            set.add(curr.val);
            curr = curr.next;
        }
        
        return dummy.next;
        
    }
}