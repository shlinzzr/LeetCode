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
        ListNode prev = new ListNode();
        ListNode curr = head;
        List<ListNode > list = new ArrayList<>();

        int cnt = 0;

       
        while(curr!=null){

            if(cnt++%k==0){
                prev.next = null;
                list.add(curr);
            }
            prev = curr;
            curr = curr.next;
        }


        boolean rev = (cnt%k==0);
        
        ListNode dummy = new ListNode();
        curr = dummy;
        for(int i=0; i<list.size(); i++){
            ListNode node = list.get(i);

            if(i==list.size()-1 && !rev ){
                curr.next=node;
            }else{
                curr.next = reverse(node);
                curr = node;
            }
        }

        return dummy.next;

    }

    private ListNode reverse( ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }

        return prev;
    }
}