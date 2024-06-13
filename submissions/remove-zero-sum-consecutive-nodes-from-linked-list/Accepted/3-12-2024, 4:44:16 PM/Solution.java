// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list

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
    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        HashMap<Integer, ListNode > map = new HashMap<>();
        int presum = 0;
        while(curr!=null){
            presum += curr.val;
            if(map.containsKey(presum)){
                ListNode to_del = map.get(presum).next;
                int p = presum + to_del.val;
                while(p!=presum){
                    map.remove(p);
                    to_del=to_del.next;
                    p+=to_del.val;
                }
                map.get(presum).next = to_del.next;
            }else{
                map.put(presum, curr);
            }
            curr = curr.next;
        }

        return dummy.next;
        
    }
}