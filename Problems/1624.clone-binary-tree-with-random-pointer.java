// https://leetcode.com/problems/clone-binary-tree-with-random-pointer

/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root==null)
            return null;
        HashMap<Node, NodeCopy> map = new HashMap<>();
        NodeCopy copy = helper(root, map);
        helper2(root, map);
        return copy;
    }
    
    private NodeCopy helper(Node root, HashMap<Node, NodeCopy> map){
        if(root==null)
            return null;
        
        NodeCopy copy = new NodeCopy(root.val);
        
        copy.left = helper(root.left, map);
        copy.right = helper(root.right, map);
        
        map.put(root, copy);
        
        return copy;
    }
    
    private void helper2(Node root, HashMap<Node, NodeCopy> map){
        if(root==null)
            return;
        
        NodeCopy copy = map.get(root);
        copy.random = map.get(root.random);
        
        helper2(root.left, map);
        helper2(root.right, map);
    }
}