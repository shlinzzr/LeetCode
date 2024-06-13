// https://leetcode.com/problems/populating-next-right-pointers-in-each-node

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node node =  root;
        while(node!=null){
            
            Node curr = node;
            while(curr!=null){
                
                if(curr.left!=null){
                    curr.left.next=curr.right;    
                }
                
                if(curr.right!=null && curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;                
            }
            
            node=node.left;
        }
        
        return root;
    }
    
}

// class Solution {
//     public Node connect(Node root) {
        
//         Node n = root;
//         while(n!=null){
//             Node curr = n;
//             while(curr!=null){
                
//                 if(curr.left!=null)
//                     curr.left.next = curr.right;
//                 if(curr.right!=null && curr.next!=null)
//                     curr.right.next = curr.next.left;
                
//                 curr = curr.next;                
//             }
            
//             n = n.left;
//         }
        
        
//         return root;
//     }
    
    
// }

