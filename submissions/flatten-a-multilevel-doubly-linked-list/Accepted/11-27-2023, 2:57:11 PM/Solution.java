// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        helper(head);
        return head;
    }

    private Node helper(Node node){

        Node prev = null;
        Node curr = node;
        while(curr!=null){
            Node next = curr.next; // 4, 9 

            if(curr.child!=null){
                curr.next = curr.child; // 3->7, 8->11
                curr.child.prev = curr; // 7->3 11->8
                
                Node last = helper(curr.child); //helper(7, 4)
                curr.child = null;
                last.next = next;

                if(next!=null)
                    next.prev = last;
                
                prev = last;
            }else{
                prev = curr;
            }
            curr = next;
        }

        return prev;


    }
}