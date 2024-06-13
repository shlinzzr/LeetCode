// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

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

        Node res = root;

        Node nextLevelDummy = new Node();
        Node prev = nextLevelDummy;

        while(root!=null){

            if(root.left!=null){
                prev.next = root.left;
                prev = prev.next;
            }
            if(root.right!=null){
                prev.next = root.right;
                prev = prev.next;
            }

            root = root.next;

            if(root==null){
                root = nextLevelDummy.next;
                nextLevelDummy.next = null;
                prev = nextLevelDummy;
            }
        }

        return res;
        
    }
}