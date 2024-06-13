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
        
        if(head==null)
            return null;
        
        Node newHead = new Node(head.val);
        
        HashMap<Node, Node> map = new HashMap<>(); // org, copied
        
        map.put(head, newHead);
        

        Node copy = newHead;
        Node org = head;
        while(org!=null){
            
            org=org.next;
            
            if(org!=null){
                Node node  = new Node(org.val);
                copy.next = node;
                
                map.put(org, node);
                
                copy=copy.next;
            }
        }
        
        org = head;
        copy = newHead;
        while(org!=null){
            
            copy.random = map.get(org.random);
            copy = copy.next;
            org = org.next;
        }
        
        return newHead;
    }
}