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
            
            ListNode L = list.get(left);//3
            ListNode R = list.get(right);//5
            
            ListNode Rnext = R.next;//null
            ListNode Lnext = L.next;// 5
            
            ListNode Rprev = right==0? dummy : list.get(right-1);
            ListNode Lprev = left==0? dummy : list.get(left-1);
            
            Lprev.next = R; //dummy.next = R;
            
            if(L.next != R){
                R.next = Lnext; // 5 -> 5
                Rprev.next = L; // 3->3                
            }else{
                R.next=L;
            }
            L.next = Rnext;
            

            
            
            left++;
            right--;
            
        } 
        
        return dummy.next;
        
    }
}