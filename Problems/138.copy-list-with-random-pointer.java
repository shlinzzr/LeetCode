// https://leetcode.com/problems/copy-list-with-random-pointer

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Node dummy = new Node(0);
        Node prev = dummy; 
        
        Node iter = head;
        while(iter!=null){
            Node node = new Node(iter.val);
            prev.next = node;
            prev = prev.next;
            
            map.put(iter, node);
            
            iter = iter.next;
        }
        
        iter = head;
        while(iter!=null){
            
            Node node = map.get(iter);
            if(iter.random!=null){
                node.random = map.get(iter.random);
            }
            iter=iter.next;
        }
        
        return dummy.next;
        
        
        
        
    }
}