// https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list

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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        ListNode curr = head;
        while(curr!=null){
            map.put(curr.val, map.getOrDefault(curr.val, 0)+1);
            curr=curr.next;
        }
        
        ListNode prev=null;
        curr=head;
        while(curr!=null){
            
            if(map.get(curr.val)>1){
                curr=curr.next;
                prev.next=null;
                continue;
            }
            
            if(prev==null){
                head=curr;
            }else{
                prev.next=curr;
            }
            
            prev=curr;
            curr=curr.next;
        }
        
        return head;
        
        
        // ListNode ret = new ListNode();
//         curr = ret;
//         for(int i=0; i<list.size(); i++){
//             ListNode node = new ListNode(list.get(i));
//             curr.next=node;
//             curr=curr.next;
//         }
        
        // return ret;
        
    }
}