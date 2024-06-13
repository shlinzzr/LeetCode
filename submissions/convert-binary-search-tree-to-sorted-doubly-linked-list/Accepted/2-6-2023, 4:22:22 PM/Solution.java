// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    Node prev = null;
    
    public Node treeToDoublyList(Node root) {
        
        if(root==null)
            return root;
        
        Node dummy = new Node();
        prev=dummy;
        
        helper(root);

        prev.right=dummy.right;
        dummy.right.left=prev;
        
        return dummy.right;
        
    }
    
    
    private void helper(Node curr){
        
        if(curr==null)
            return ;
        
        helper(curr.left);
        prev.right=curr;
        curr.left=prev;
        
        prev=curr;
        helper(curr.right);
    }
    
    
    
}