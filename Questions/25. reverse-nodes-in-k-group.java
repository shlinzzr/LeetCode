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

        ListNode curr = head;
        ListNode prev = new ListNode();

        int cnt=0;
        while(curr!=null){
            if(cnt%k==0){
                prev.next = null;
                list.add(curr);
            }
            prev=curr;
            curr=curr.next;
            cnt++;
        }

        boolean needRev = cnt%k==0 ? true : false;

        ListNode dummy = new ListNode();
         curr = dummy;
        for(int i=0; i<list.size(); i++){

            ListNode node = list.get(i);

            if(i==list.size()-1 && needRev==false){
                curr.next = node;
                break;
            }
            
            curr.next = reverse(node);
            curr = node;
        }

        return dummy.next;
        
        


    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;

        while(node!=null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}