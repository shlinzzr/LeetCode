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

        int len = 0;
        ListNode curr = head;
        while(curr!=null){
            len++;
            curr = curr.next;
        }
        k%=len;
        if(k==0) return head;

        List<ListNode> list = new ArrayList<>();


        boolean lastRev = false;
        ListNode prev = new ListNode();
        curr= head;
        while(curr!=null){

            list.add(curr);
            int cnt = 0;
            while(curr!=null && cnt++<k){
                prev=curr;
                curr=curr.next;
            }

            prev.next = null;
            if(cnt==k) lastRev = true;
            else lastRev = false;
        }


        ListNode dummy = new ListNode();
        for(int i=list.size()-1; i>=0; i--){
            ListNode node = list.get(i);

            if(i==list.size()-1){
                if(lastRev){
                    dummy = reverse(node, null);
                }else{
                    dummy = node;
                }
            }else{
                dummy = reverse(node, dummy);
            }

            // print(dummy);
        }

        return dummy;
    }
    
    // private void print(ListNode node){
    //     while(node!=null){
    //         System.out.print(node.val+ ",");
    //         node=node.next;
    //     }
    //     System.out.println();
    // }
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