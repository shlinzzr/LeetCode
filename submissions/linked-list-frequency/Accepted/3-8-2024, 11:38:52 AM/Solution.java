// https://leetcode.com/problems/linked-list-frequency

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
    public ListNode frequenciesOfElements(ListNode head) {

        HashMap<Integer, Integer> map = new HashMap<>();

        ListNode cur = head;

        while(cur!=null){
            map.put(cur.val, map.getOrDefault(cur.val,0)+1);
            cur=cur.next;
        }


        ListNode dummy = new ListNode();
        cur = dummy;
        for(int k : map.keySet()){
            ListNode node = new ListNode(map.get(k));
            cur.next = node;
            cur = node;
        }

        return dummy.next;


        
    }
}