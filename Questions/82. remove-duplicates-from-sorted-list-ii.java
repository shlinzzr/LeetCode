// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

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
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = head;
        while(curr!=null){
            map.put(curr.val, map.getOrDefault(curr.val, 0)+1);
            curr= curr.next;
        }


        HashSet<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            if(en.getValue()>1){
                set.add(en.getKey());
            }
        }

        
        while(head!=null && set.contains(head.val)){
            head=head.next;
        }

        ListNode prev= new ListNode();
        prev.next=head;
        curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            while(next!=null && set.contains(next.val)){
                next = next.next;
            }
            curr.next = next;
            curr = curr.next;
        }

        return head;
    
    }

}