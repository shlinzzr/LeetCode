// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {

        ListNode curr = head;
        int cnt = 0;
        while(curr!=null){
            curr=curr.next;
            cnt++;
        }

        int len = cnt;
        k = k%len;
        k = len-k;

        //
        curr = head;
        cnt = 0;    
        ListNode prev= new ListNode();

        while(cnt<k){
            prev= curr;
            curr = curr.next;
            cnt++;
        }
        prev.next = null;
        ListNode res=curr;
        while(curr!=null){
            prev=curr;
            curr= curr.next;   
        }
        prev.next=head;
        return res;


        
    }
}