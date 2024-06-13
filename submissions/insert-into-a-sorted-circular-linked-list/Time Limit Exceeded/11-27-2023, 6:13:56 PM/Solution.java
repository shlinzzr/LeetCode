// https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {

        if(head==null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        if(head!=null && head.next==head){
            Node node = new Node(insertVal);
            head.next = node;
            node.next=head;
            return head;
        }


        Set<Node> set = new HashSet<>();
        Node prev = null;
        Node curr = head;
        Node last = null;
        Node min = curr;
        while(curr!=null && !set.contains(curr)){
            set.add(curr);
            if(curr.val<min.val){
                min = curr;
                last = prev;
            }
            prev = curr;
            curr = curr.next;
        }


        if(last!=null)
            last.next = null;

        curr = min;
        while(curr !=null){
                   Node next = curr.next;
            // System.out.println("curr.val="+curr.val + " next="+next.val);
     

            if(next==null || (curr.val<=insertVal && next.val>=insertVal)){

                // System.out.println("chello");
                Node ins = new Node(insertVal);
                curr.next=ins;
                ins.next = next;
                if(last!=null){
                    last.next = min;
                }
                return head;
            }
            curr = next;

                // System.out.println("noo");
        }
        
        return head;

    }
}