// https://leetcode.com/problems/n-ary-tree-postorder-traversal

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        
        if(root==null)
            return res;
        
        helper(root);
        
        return res;
    }
    
    
    private void helper(Node root){
        if(root==null)
            return;
        
        List<Node> children = root.children;
        for(Node child : children){
            helper(child);    
        }
        res.add(root.val);
        
        return ;
    }
}