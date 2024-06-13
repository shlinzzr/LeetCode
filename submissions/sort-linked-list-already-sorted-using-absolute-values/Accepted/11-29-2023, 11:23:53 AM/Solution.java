// https://leetcode.com/problems/sort-linked-list-already-sorted-using-absolute-values

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
    public ListNode sortLinkedList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            list.add(curr);
            curr = curr.next;
        }

        Collections.sort(list, (a,b)-> a.val-b.val);

        for(int i=0; i<list.size()-1; i++){
            list.get(i).next = list.get(i+1);
        }

        list.get(list.size()-1).next = null;

        return list.get(0);

    }
}