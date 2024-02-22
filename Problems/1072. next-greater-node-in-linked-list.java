// https://leetcode.com/problems/next-greater-node-in-linked-list

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
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();

        ListNode curr = head;
        int cnt = 1;

        if(head==null)  
            return new int[0];

        HashMap<ListNode, Integer> map = new HashMap<>(); // node, idx

        HashMap<Integer, Integer> tmp = new HashMap<>();

        while(curr!=null){
            map.put(curr, cnt-1);

            while(!st.isEmpty() && st.peek().val<curr.val){
                tmp.put(map.get(st.pop()), curr.val);
            }
            st.push(curr);

            curr=curr.next;
            cnt++;
        }

        int[] res = new int[cnt-1];
        for(int i=0; i<cnt-1; i++){
            res[i] = tmp.getOrDefault(i,0);
        }

        return res;
    }
}