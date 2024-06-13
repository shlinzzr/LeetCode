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
        LinkedHashMap<Integer, List<ListNode>> map = new LinkedHashMap<>();
        
        
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            map.putIfAbsent(curr.val, new ArrayList<>());
            map.get(curr.val).add(prev);
            prev = curr;
            curr=curr.next;
        }
        
        Stack<Map.Entry<Integer, List<ListNode>>> st = new Stack<>();
        for(Map.Entry<Integer, List<ListNode>> en : map.entrySet()){
            st.push(en);
        }
        
        
        
        while(!st.isEmpty()){
        // for(Map.Entry<Integer, List<ListNode>> en : map.entrySet()){
            
            Map.Entry<Integer, List<ListNode>> en = st.pop();
            
            List<ListNode> list = en.getValue();
            
            if(list.size()>1){
                for(int i=list.size()-1; i>=0; i--){
                    ListNode node = list.get(i);
                    if(node!=null){
                        ListNode next = node.next.next;
                        node.next = next;
                    }
                }
            }
        }
        
        return head;
    }
}