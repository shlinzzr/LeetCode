// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<ListNode> list = new ArrayList<>();
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        list.add(dummy); // dummy
        
        ListNode curr = head;
        while(curr!=null){
            list.add(curr);
            curr=curr.next;
        }
        
        while(left<right){
            
            ListNode L = list.get(left);
            ListNode R = list.get(right);
            
            ListNode Rnext = R.next;
            ListNode Lnext = L.next;
            
            ListNode Rprev = right==0? dummy : list.get(right-1);
            ListNode Lprev = left==0? dummy : list.get(left-1);
            
            Lprev.next = R;
            R.next = Lnext;
            Rprev.next = L;
            L.next = Rnext;
            
            left++;
            right--;
            
        } 
        
        return dummy.next;
        
    }
}