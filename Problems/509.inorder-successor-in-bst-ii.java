// https://leetcode.com/problems/inorder-successor-in-bst-ii

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {

    Node prev = null;
    public Node inorderSuccessor(Node node) {
        if(node==null) return null;

        Node target = node;

        Node root = getRoot(node);

        return helper(root, target);


    }


    private Node helper(Node node, Node target){
        if(node==null) return null;

        Node left = helper(node.left, target);
        if(left!=null) return left;

        if(prev==target){
            return node;
        }
        prev = node;
        Node right = helper(node.right, target);
        if(right!=null) return right;

        return null;
    }

    private Node getRoot(Node node){
        while(node.parent!=null)
            node = node.parent;
        return node;
    }
}