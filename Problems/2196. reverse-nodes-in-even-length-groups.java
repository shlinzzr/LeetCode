// https://leetcode.com/problems/reverse-nodes-in-even-length-groups

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
    public ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode prev = new ListNode();
        ListNode curr = head;
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        int cnt = 0;
        int target = 1;

        while(curr!=null){

            cnt++;
            ListNode next = curr.next;

            if(cnt==target){
                curr.next = null;
                if(next!=null)
                    list.add(next);
                target++;
                cnt=0;
            }

            curr = next;
        }

        ListNode dummy = new ListNode();
        curr = dummy;
        for(int i=0; i<list.size(); i++){
          
            ListNode node = list.get(i);
    //          System.out.println();
    //     System.out.println("node:");
            cnt = 0;
            ListNode cur = node;
            while(cur!=null){
                cnt++;
                cur=cur.next;
            }


    // // System.out.println();
    // //     System.out.println("tail:");
    // //         ListNode tail =  reverse(node);
            
    // //          cur = tail;
    // //         while(cur!=null){
    // //             System.out.println(cur.val);
    // //             prev= cur;
    // //             cur=cur.next;
    // //         }
    // //          reverse(prev);

            

            if(cnt%2==1 ){
                curr.next = node;
                while(node!=null){
                    curr = node;
                    node = node.next;
                }
            }else{
                node = reverse(node);
                curr.next = node;
                while(node!=null){
                    curr = node;
                    node = node.next;
                }
            }
        }

        return dummy.next;


        
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
        
    }
}