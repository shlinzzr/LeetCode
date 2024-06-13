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
        
        Node prev = head;
        Node next = head.next;
        
        while(true){
            if(prev.val<=insertVal && insertVal<=next.val){
                break;
                // next 比 prev小: 此時next是起點 prev是終點, check insert val 比大的大或比小的小
            }else if(next.val<prev.val && (insertVal>prev.val || insertVal<next.val)){
                break;
            }
            
            prev=next;
            next=next.next;
                
            if(prev==head) //找完一圈了
                break;
        }
        
        Node node = new Node(insertVal);
        prev.next = node;
        node.next = next;
        
        return head;
        
    }
}