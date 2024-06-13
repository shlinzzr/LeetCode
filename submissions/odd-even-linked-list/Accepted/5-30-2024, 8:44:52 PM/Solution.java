// https://leetcode.com/problems/odd-even-linked-list

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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode oddDummy = new ListNode();
        oddDummy.next = head;

        ListNode evenDummy = new ListNode();

        ListNode odd = oddDummy;
        ListNode even = evenDummy;

       

        ListNode curr = head;
        
        while(curr!=null){

            ListNode next = curr.next;

            odd.next = curr;
            odd = odd.next;
            
            even.next = next;
            even = even.next;

            if(next==null || next.next==null){
                break;
            }
            curr= next.next;

        }

        odd.next = evenDummy.next;
        if(even!=null)
            even.next = null;

        if(oddDummy.next!=null) return oddDummy.next;

        return evenDummy.next;




        // // tmd 題目要看清楚拉
        // ListNode oddDummy = new ListNode();
        // ListNode evenDummy = new ListNode();
        // ListNode even = evenDummy;
        // ListNode odd = oddDummy;

        // ListNode curr = head;
        // while(curr!=null){
        //     if(curr.val%2==0){
                
        //         even.next = curr;
        //         even = even.next;
        //     }else{
        //         odd.next = curr;
        //         odd = odd.next;
        //     }
            
        //     curr = curr.next;
        // }

        // odd.next = evenDummy.next;
        // even.next = null;

        // if(oddDummy.next!=null) return oddDummy.next;
        // return evenDummy.next;
        
        

        
    }
}