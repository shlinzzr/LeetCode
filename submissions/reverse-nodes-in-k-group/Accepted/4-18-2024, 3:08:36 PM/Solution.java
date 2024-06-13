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

        List<ListNode> list = new ArrayList<>();
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode dummy =head;

        boolean last = true;

        ListNode curr = head;
        while(curr!=null){

            int cnt=k;
            while(curr!=null && cnt>0){

                cnt--;
                prev = curr;
                curr=curr.next;
            }

            if(cnt>0) last = false;
            else last = true;
            list.add(dummy);
            prev.next=null;
            dummy=curr;
        }

        dummy = null;

        for(int i=list.size()-1; i>=0; i--){

            if(i==list.size()-1){

                if(last){
                    dummy = reverse(list.get(i), dummy);
                }else{
                    dummy = list.get(i);
                }

            }else{
                dummy = reverse(list.get(i), dummy);
            }
        }

        return dummy;
        
    }

    private ListNode reverse(ListNode node, ListNode prev){
        while(node!=null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }   

        return prev;
    }
}